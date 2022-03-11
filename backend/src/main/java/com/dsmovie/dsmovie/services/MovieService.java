package com.dsmovie.dsmovie.services;

import com.dsmovie.dsmovie.dto.MovieDTO;
import com.dsmovie.dsmovie.entities.Movie;
import com.dsmovie.dsmovie.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

  @Autowired
  private MovieRepository repository;

  @Transactional(readOnly = true)
  public Page<MovieDTO> findAll(Pageable pageable) {
    
    Page<Movie> result = this.repository.findAll(pageable);
    Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
    return page;
  }

  @Transactional(readOnly = true)
  public MovieDTO findById(Long id) throws Exception {
    
    try{
      Movie result = this.repository.findById(id).get();
      MovieDTO page = new MovieDTO(result);
      return page;

    } catch (Exception e) {

      throw new Exception("invalid parameter, identifier not found!" + e);
    }
  }
  
}