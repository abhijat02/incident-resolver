package com.demo.ai_incident_resolver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OllamaRequest {

    private String model;
    private String prompt;
    private boolean stream;
}
