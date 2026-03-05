package com.demo.ai_incident_resolver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.ai_incident_resolver.entity.IncidentEntity;
import com.demo.ai_incident_resolver.repository.IncidentRepository;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository){
        this.incidentRepository = incidentRepository;
    }

    public IncidentEntity createIncident(IncidentEntity incident){
        incident.setStatus("OPEN");
        return incidentRepository.save(incident);
    }

    public List<IncidentEntity> getAllIncidents(){
        return incidentRepository.findAll();
    }
}
