package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.Genre;

public interface GenreRepository {

	List<Genre> addGenre(List<Genre> genres);

}
