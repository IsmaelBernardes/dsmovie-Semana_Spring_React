package com.dsmovie.dsmovie.services;

import com.dsmovie.dsmovie.dto.MovieDTO;
import com.dsmovie.dsmovie.dto.ScoreDTO;
import com.dsmovie.dsmovie.entities.Movie;
import com.dsmovie.dsmovie.entities.Score;
import com.dsmovie.dsmovie.entities.User;
import com.dsmovie.dsmovie.repositories.MovieRepository;
import com.dsmovie.dsmovie.repositories.ScoreRepository;
import com.dsmovie.dsmovie.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

@Service
public class ScoreService {

  @Autowired
  private MovieRepository movieRepository;
  
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private ScoreRepository scoreRepository;
  
  @Transactional
  public MovieDTO saveScore(ScoreDTO scoredto) {
    
    User user = userRepository.findByEmail(scoredto.getEmail());

    if (user == null) {
      user = new User();
      user.setEmail(scoredto.getEmail());
      user = userRepository.saveAndFlush(user);
    }

    Movie movie = movieRepository.findById(scoredto.getMovieId()).get();

    Score score = new Score();
    score.setMovie(movie);
    score.setUser(user);
    score.setValue(scoredto.getScore());

    score = scoreRepository.saveAndFlush(score);

    double sum = 0.0;
    for (Score s : movie.getScores()) {
      sum = sum + s.getValue();
    }

    double avg = sum / movie.getScores().size();

    movie.setScore(avg);
    movie.setCount(movie.getScores().size());
    
    movie = movieRepository.save(movie);

    return new MovieDTO(movie);
  }
}