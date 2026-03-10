package com.demo.ai_incident_resolver.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.ai_incident_resolver.dto.OllamaRequest;
import com.demo.ai_incident_resolver.dto.OllamaResponse;


@Service
public class AIAnalysisService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String analyze(String errorMessage){

        String prompt = """
                You are a DevOps AI assistant.
                Analyze this production error log and return:

                1. Severity
                2. Root Cause
                3. Suggested Fix

                Error Log:
                """+ errorMessage;

        OllamaRequest request = OllamaRequest.builder()
                                .model("llama3")
                                .prompt(prompt)
                                .stream(false)
                                .build();

        OllamaResponse response = restTemplate.postForObject(
            "http://localhost:11434/api/generate",
            request,
            OllamaResponse.class
        );

        return response.getResponse();
    }

    
}
