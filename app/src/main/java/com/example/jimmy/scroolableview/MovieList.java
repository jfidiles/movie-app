package com.example.jimmy.scroolableview;

/**
 * Created by Jimmy on 3/6/2016.
 */
public class MovieList {
    private String title;
    private String[] movieId;
    private String[] imageUrl;

    public MovieList(String title, String[] movieId, String[] imageUrl) {
        this.title = title;
        this.movieId = movieId;
        this.imageUrl = imageUrl;
    }
}
