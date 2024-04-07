package com.quiz.app.repository;

import com.quiz.app.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findAllByOrderByTotalCorrectDescPercentageDescSubmittedAtDesc();

    List<Result> findTop15ByOrderByTotalCorrectDescPercentageDescSubmittedAtDesc();
}
