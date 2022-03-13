package com.dsmovie.dsmovie.controllers;

import com.dsmovie.dsmovie.dto.MovieDTO;
import com.dsmovie.dsmovie.dto.ScoreDTO;
import com.dsmovie.dsmovie.services.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreControllers {
  
  @Autowired
  private ScoreService scoreService;

  @PutMapping
  public MovieDTO saveScore(@RequestBody ScoreDTO scoredto) {
    
    MovieDTO movie = scoreService.saveScore(scoredto);
    return movie;
  }
}
