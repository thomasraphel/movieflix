package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Crew;
import io.egen.movieflix.repository.CrewRepository;

@Service
@Transactional
public class CrewServiceImpl implements CrewService {

	@Autowired
	private CrewRepository repository;

	public List<Crew> addCrew(List<Crew> crewList) {
		
		return repository.addCrew(crewList);
	}
	
	
}
