package com.example.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;
import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    String backdropPath;
    String posterpath;
    String title;
    String overview;
    public  Movie() {}
    Double voteAverage;

    public Double getVoteAverage() {
        return voteAverage;
    }

    public Movie(JSONObject movie) throws JSONException {
        backdropPath = movie.getString("backdrop_path");
        posterpath = movie.getString("poster_path");

        title = movie.getString("title");
        overview = movie.getString("overview");
        voteAverage = movie.getDouble("vote_average");

    }
    public static List<Movie>fromJsonArray(JSONArray moviejsonArrayy) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < moviejsonArrayy.length(); i++) {
             movies.add(new Movie(moviejsonArrayy.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterpath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterpath);
    }
    public  String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
