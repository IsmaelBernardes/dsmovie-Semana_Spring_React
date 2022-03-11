package com.dsmovie.dsmovie.repositories;

import com.dsmovie.dsmovie.entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  
}