package com.demo.ai_incident_resolver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ai_incident_resolver.entity.IncidentEntity;

public interface IncidentRepository  extends JpaRepository<IncidentEntity,Long>{

}
