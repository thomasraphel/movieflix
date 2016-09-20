package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.Genre;

@Repository
public class GenreRepositoryImpl implements GenreRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Genre> addGenre(List<Genre> genres) {
		for(Genre genre:genres)
			em.persist(genre);
		return genres;
	}

}
