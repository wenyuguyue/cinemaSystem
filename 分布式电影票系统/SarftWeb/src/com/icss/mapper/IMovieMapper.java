package com.icss.mapper;

import java.util.List;

import com.icss.entity.Movie;

public interface IMovieMapper {

	List<Movie> queryMovie()throws Exception;

	void deleteMovie(String code)throws Exception;

	void addMovie(Movie movie)throws Exception;

	void editMovie(Movie movie)throws Exception;

}
