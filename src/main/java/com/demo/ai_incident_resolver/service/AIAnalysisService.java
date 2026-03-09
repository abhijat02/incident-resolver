package com.demo.ai_incident_resolver.service;

import org.springframework.stereotype.Service;

import com.demo.ai_incident_resolver.dto.IncidentAnalysisResponse;

@Service
public class AIAnalysisService {

    public IncidentAnalysisResponse analyze(String errorMessage){

        String severity;
        String recommendation;

        if(errorMessage.toLowerCase().contains("database")){
            severity = "HIGH";
            recommendation = "Check database connection and restart DB service";
        }
        else if(errorMessage.toLowerCase().contains("timeout")){
            severity = "MEDIUM";
            recommendation = "Check network latency or increase timeout configuration";
        }
        else if(errorMessage.toLowerCase().contains("null")){
            severity = "LOW";
            recommendation = "Check null handling in application logic";
        }
        else{
            severity = "UNKNOWN";
            recommendation = "Manual investigation required";
        }

        return IncidentAnalysisResponse.builder()
               .severity(severity)
               .recommendation(recommendation)
               .build();
    }

    
}
