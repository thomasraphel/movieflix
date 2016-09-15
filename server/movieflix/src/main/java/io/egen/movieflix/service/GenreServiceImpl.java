package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Genre;
import io.egen.movieflix.repository.GenreRepository;

@Service
@Transactional
public class GenreServiceImpl implements GenreService{

	@Autowired
	private GenreRepository repository;
	
	@Override
	public List<Genre> addGenre(List<Genre> genres) {
		
		return repository.addGenre(genres);
	}

}
