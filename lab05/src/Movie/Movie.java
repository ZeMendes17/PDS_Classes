package src.Movie;

import java.util.List;
import java.util.ArrayList;

public class Movie {
    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;


    public static class Builder {
        // Required Parameters
        private final String movieTitle;
        private final int movieYear;

        // Optional Parameters initialized with default values
        private Person movieDirector = new Person("", 0, 0);
        private Person movieWriter = new Person("", 0, 0);
        private String movieSeries = "";
        private List<Person> movieCast = new ArrayList<Person>();
        private List<Place> movieLocations = new ArrayList<Place>();
        private List<String> movieLanguages = new ArrayList<String>();
        private List<String> movieGenres = new ArrayList<String>();
        private boolean television = false;
        private boolean netflix = false;
        private boolean independent = false;

        // Methods
        public Builder(String movieTitle, int movieYear){
            this.movieTitle = movieTitle;
            this.movieYear = movieYear;
        }
        public Builder movieDirector(Person p){
            movieDirector = p;
            return this;
        }
        public Builder movieWriter(Person p){
            movieWriter = p;
            return this;
        }
        public Builder movieSeries(String s){
            movieSeries = s;
            return this;
        }
        public Builder movieCast(List<Person> l){
            movieCast = l;
            return this;
        }
        public Builder movieLocations(List<Place> l){
            movieLocations = l;
            return this;
        }
        public Builder movieLanguages(List<String> l){
            movieLanguages = l;
            return this;
        }
        public Builder movieGenres(List<String>l){
            movieGenres = l;
            return this;
        }
        public Builder television(boolean b){
            television = b;
            return this;
        }
        public Builder netflix(boolean b){
            netflix = b;
            return this;
        }
        public Builder independent(boolean b){
            independent = b;
            return this;
        }

        // Build the Movie
        public Movie build(){
            return new Movie(this);
        }
    }

    // Movie Constructor
    private Movie(Builder b){
        title = b.movieTitle;
        year = b.movieYear;
        director = b.movieDirector;
        writer = b.movieWriter;
        series = b.movieSeries;
        cast = b.movieCast;
        locations = b.movieLocations;
        languages = b.movieLanguages;
        genres = b.movieGenres;
        isTelevision = b.television;
        isNetflix = b.netflix;
        isIndependent = b.independent;
    }
}