package com.dsmovie.dsmovie.repositories;

import com.dsmovie.dsmovie.entities.Score;
import com.dsmovie.dsmovie.entities.ScorePK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
  
}