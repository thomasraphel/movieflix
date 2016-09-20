package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.Crew;

public interface CrewRepository {

	List<Crew> addCrew(List<Crew> crewList);

}
