package com.mc.musiccoordinator.infra.llm.gemini.chat;

import com.mc.musiccoordinator.infra.llm.BaseModel;
import com.mc.musiccoordinator.infra.llm.BaseRequest;
import com.mc.musiccoordinator.infra.llm.BaseResponse;
import com.mc.musiccoordinator.infra.llm.exception.ErrorCode;
import com.mc.musiccoordinator.infra.llm.exception.LLMException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class GeminiChatModel implements BaseModel {
    private static GeminiChatModel instance;
    private static String url;
    private static String apiKey;

    private GeminiChatModel(String url, String apiKey) {
        if (url == null || url.isEmpty()) {
            throw new LLMException(ErrorCode.BAD_REQUEST, "URL is null or empty");
        }
        if (apiKey == null || apiKey.isEmpty()) {
            throw new LLMException(ErrorCode.INVALID_API_KEY, "API Key is null or empty");
        }

        GeminiChatModel.url = url;
        GeminiChatModel.apiKey = apiKey;
        instance = this;
    }

    public static GeminiChatModel getInstance(String url, String apiKey) {
        if (instance == null) {
            instance = new GeminiChatModel(url, apiKey);
        }
        return instance;
    }

    @Override
    public BaseResponse invoke(BaseRequest msg) {
        String body = msg.messageToJson();

        var respDoc = getHttpResponse(body);

        assert respDoc != null;
        return parseResponse(respDoc);
    }

    private BaseResponse parseResponse(HttpResponse<String> response) {
        var resp = new GeminiResponse(response.body());

        if (resp.getErrorStatus() != null) {
            throw new LLMException(resp.getErrorStatus(), resp.getErrorMessage());
        }

        return resp;
    }

    private HttpResponse<String> getHttpResponse(String body) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            assert url != null;
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .timeout(Duration.ofMinutes(2))
                    .header("X-goog-api-key", apiKey)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            return client.send(request, BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
