package com.dsmovie.dsmovie.controllers;

import com.dsmovie.dsmovie.dto.MovieDTO;
import com.dsmovie.dsmovie.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieControllers {
  
  @Autowired
  private MovieService service;

  @GetMapping
  public Page<MovieDTO> findAll(Pageable pageable){
    
    return service.findAll(pageable);
  }

  @GetMapping("/{id}")
  public MovieDTO findAll(@PathVariable Long id) throws Exception{
    
    return service.findById(id);
  }
}
