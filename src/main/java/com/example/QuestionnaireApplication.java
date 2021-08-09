package com.example;

import com.example.entity.Answer;
import com.example.repository.AnswerRepository;
import com.example.service.ExtractService;
import com.example.util.ExtractUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class QuestionnaireApplication implements CommandLineRunner {

  @Autowired private AnswerRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(QuestionnaireApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<Answer> answers = ExtractUtil.getAnswers();
    repository.saveAll(answers);
  }
}
