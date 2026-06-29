package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class GroqService {


    @Value("${groq.api.key}")
    private String apiKey;


    private final RestClient restClient = RestClient.create();



    public String generateContent(String prompt) {


        String body = """
        {
          "model": "llama-3.3-70b-versatile",

          "response_format": {
              "type": "json_object"
          },

          "messages": [
            {
              "role": "user",
              "content": "%s"
            }
          ]
        }
        """.formatted(
                prompt
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
        );



        return restClient.post()

                .uri("https://api.groq.com/openai/v1/chat/completions")

                .header(
                    "Authorization",
                    "Bearer " + apiKey
                )

                .header(
                    "Content-Type",
                    "application/json"
                )

                .body(body)

                .retrieve()

                .body(String.class);

    }





    public String extractContent(String response) {


        try {


            ObjectMapper mapper = new ObjectMapper();


            JsonNode root =
                    mapper.readTree(response);



            return root
                    .path("choices")
                    .get(0)
                    .path("message")
                    .path("content")
                    .asText();



        } catch(Exception e){


            throw new RuntimeException(
                    "Erreur extraction réponse IA"
            );

        }

    }

}