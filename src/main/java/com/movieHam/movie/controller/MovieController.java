package com.movieHam.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import com.movieHam.common.SearchKeyword;
import com.movieHam.movie.service.Movie;
import com.movieHam.movie.service.MovieService;

import com.movieHam.common.ResultSet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping("/movie/list")
    public ResultSet getMovieList(
        @RequestBody SearchKeyword movieSearch) 
    {
        List<Movie> movieList = movieService.getMovieList(movieSearch);

        Map<String, Object> data = Map.of("data", movieList);

        ResultSet result = new ResultSet("Success", "Test", data);
        
        return result;
    }

    @GetMapping("/movie/{id}")
    public ResultSet getMovie(
        @PathVariable("id") Integer id)
    {
        Map<String, Object> data = Map.of("data", movieService.getMovie(id));
        return new ResultSet("Success", "Test", data);
    }

}
