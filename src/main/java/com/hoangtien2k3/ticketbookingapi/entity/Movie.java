package com.hoangtien2k3.ticketbookingapi.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private int movieId;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "movie_description")
    private String movieDescription;
    @Column(name = "movie_trailer")
    private String movieTrailer;
    @Column(name = "movie_cens")
    private String movieCens;
    @Column(name = "movie_genres")
    private String movieGenres;
    @Column(name = "movie_release")
    private String movieRelease;
    @Column(name = "movie_lenght")
    private String movieLength;
    @Column(name = "movie_format")
    private String movieFormat;
    @Column(name = "movie_poster")
    private String moviePoster;
}
