package com.demo.ai_incident_resolver.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ai_incident_resolver.entity.IncidentEntity;
import com.demo.ai_incident_resolver.service.IncidentService;



@RestController
@RequestMapping("/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping
    public ResponseEntity<List<IncidentEntity>> getAllIncidents(){
        return ResponseEntity.ok(incidentService.getAllIncidents());
    }

    @PostMapping
    public ResponseEntity<IncidentEntity> createIncident(@RequestBody IncidentEntity incident){
        IncidentEntity saved = incidentService.createIncident(incident);
        return ResponseEntity.status(201).body(saved);
    }
}
