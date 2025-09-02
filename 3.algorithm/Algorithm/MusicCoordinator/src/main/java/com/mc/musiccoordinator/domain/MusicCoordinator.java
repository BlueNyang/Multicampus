package com.mc.musiccoordinator.domain;

import com.mc.musiccoordinator.infra.llm.BaseModel;
import com.mc.musiccoordinator.infra.llm.LLMContext;
import com.mc.musiccoordinator.infra.llm.LLMProvider;
import com.mc.musiccoordinator.infra.llm.exception.LLMException;
import com.mc.musiccoordinator.infra.llm.gemini.chat.GeminiRequest;
import com.mc.musiccoordinator.infra.qrcode.QrCodeGenerator;
import com.mc.musiccoordinator.infra.qrcode.dto.QrCodeDto;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class MusicCoordinator {
    private final String geminiUrl;
    private final String geminiKey;

    public MusicCoordinator() {
        var dotenv = Dotenv.configure()
                .directory("./MusicCoordinator")
                .filename(".env")
                .load();


        this.geminiUrl = dotenv.get("GEMINI_URL");
        this.geminiKey = dotenv.get("GEMINI_KEY");
    }

    public Optional<Music> recommend(String prompt) {
        prompt += ". 이 감정에 어울리는 노래를 1곡 추천해줘. 이유도 함께 알려줘.";
        try {
            BaseModel model = new LLMContext().initChatModel(LLMProvider.GEMINI, geminiUrl, geminiKey);
            var musics = model.invoke(new GeminiRequest<>(prompt, MusicGeminiType.INSTANCE));
            Music music = Music.fromMap(musics.messageToMap().getFirst());
            String query = music.artist() + " " + music.name();
            query = URLEncoder.encode(query, StandardCharsets.UTF_8);
            String qrCodeText = "https://www.youtube.com/results?search_query=" + query;

            QrCodeGenerator gen = new QrCodeGenerator();
            QrCodeDto dto = new QrCodeDto(qrCodeText, music.name());
            gen.generate(dto);

            return Optional.of(music);
        } catch (LLMException e) {
            System.err.println("LLM Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("General Error: " + e.getMessage());
        }
        return Optional.empty();
    }
}
