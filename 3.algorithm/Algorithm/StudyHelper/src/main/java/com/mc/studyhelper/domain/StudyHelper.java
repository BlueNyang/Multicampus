package com.mc.studyhelper.domain;

import com.mc.musiccoordinator.infra.llm.BaseModel;
import com.mc.musiccoordinator.infra.llm.BaseRequest;
import com.mc.musiccoordinator.infra.llm.LLMContext;
import com.mc.musiccoordinator.infra.llm.LLMProvider;
import com.mc.musiccoordinator.infra.llm.gemini.chat.GeminiRequest;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;

public class StudyHelper {
    private final String url;
    private final String apiKey;

    private BaseModel model;

    public StudyHelper() {
        Dotenv dotenv = Dotenv.configure()
                .directory("./StudyHelper")
                .filename(".env")
                .load();

        this.url = dotenv.get("GEMINI_URL");
        this.apiKey = dotenv.get("GEMINI_KEY");

        model = new LLMContext().initChatModel(
                LLMProvider.GEMINI, this.url, this.apiKey
        );
    }

    public List<StudyPlan> execute(String prompt) {
        prompt += ".  이 프로그래밍 언어의 난이도, 미리 학습하면 좋은 프로그래밍 언어, "
                + "학습 소요기간, 학습 후 하면 좋은 프로젝트 아이디어를 총 3번에 걸쳐 추천해줘. 한글로 말해줘.";
        var req = new GeminiRequest<>(prompt, StudyPlanFormat.INSTANCE);
        var resp = model.invoke(req);
        var res = resp.messageToMap();
        return res.stream().map(StudyPlan::fromMap).toList();
    }
}
