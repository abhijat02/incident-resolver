package com.demo.ai_incident_resolver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.ai_incident_resolver.entity.IncidentEntity;
import com.demo.ai_incident_resolver.repository.IncidentRepository;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final AIAnalysisService aiAnalysisService;

    public IncidentService(IncidentRepository incidentRepository, AIAnalysisService aiAnalysisService) {
        this.incidentRepository = incidentRepository;
        this.aiAnalysisService = aiAnalysisService;
    }

    public IncidentEntity createIncident(IncidentEntity incident){
        var analysis = aiAnalysisService.analyze(incident.getErrorMessage());

        incident.setSeverity(analysis.getSeverity());
        incident.setStatus("OPEN");

        return incidentRepository.save(incident);
    }

    public List<IncidentEntity> getAllIncidents(){
        return incidentRepository.findAll();
    }
}
