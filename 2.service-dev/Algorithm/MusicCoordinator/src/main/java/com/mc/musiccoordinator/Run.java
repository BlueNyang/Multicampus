package com.mc.musiccoordinator;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Run {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
                .directory("./MusicCoordinator")
                .filename(".env")
                .load();


        String geminiUrl = dotenv.get("GEMINI_URL");
        String geminiKey = dotenv.get("GEMINI_KEY");

        String jsonPayload = """
                {
                    "contents": [{
                        "parts": [{
                            "text": "나는 지금 행복해. 이걸 나타내는 음악을 추천해줘 (한글 답변)"
                        }]
                    }],
                    "generationConfig": {
                        "responseMimeType": "application/json",
                        "responseSchema": {
                            "type": "OBJECT",
                            "properties": {
                                "name": { "type": "STRING" },
                                "artist": { "type": "STRING"},
                                "reason": { "type": "STRING"}
                            },
                            "propertyOrdering": ["name", "artist", "reason"]
                        }
                    }
                }
                """;

        try (HttpClient client = HttpClient.newHttpClient()) {
            assert geminiUrl != null;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(geminiUrl))
                    .timeout(Duration.ofMinutes(2))
                    .header("X-goog-api-key", geminiKey)
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(jsonPayload))
                    .build();

            HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response: " + resp.body());

//            Gson gson = new GsonBuilder()
//                    .setPrettyPrinting()
//                    .create();

//            String jsonText = "{\"name\":\"BlueNyang\", \"age\":25}";
//            Test t = gson.fromJson(jsonText, Test.class);
//            System.out.println(t);
//
//            Test dummy = new Test("BlueNyang", 25);
//            String res = gson.toJson(dummy);
//            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    static class Test {
//        private String name;
//        private int age;
//
//        public Test(String name, int age) {
//            this.name = name;
//            this.age = age;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        @Override
//        public String toString() {
//            return "Test{name='" + name + "', age=" + age + "}";
//        }
//    }
}
