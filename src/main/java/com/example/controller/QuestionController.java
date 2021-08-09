package com.example.controller;

import com.example.entity.Answer;
import com.example.model.AnswerDto;
import com.example.model.QuestionDto;
import com.example.repository.AnswerRepository;
import com.example.service.ExtractService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("question")
@Log4j2
public class QuestionController {

  @Autowired private ExtractService extractService;
  @Autowired private AnswerRepository answerRepository;

  @GetMapping("/questions")
  public ResponseEntity<List<QuestionDto>> getQuestions() {
    List<QuestionDto> questions = extractService.getQuestions();
    log.debug(questions);
    if (!CollectionUtils.isEmpty(questions)) return ResponseEntity.ok(questions);
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/answers")
  public ResponseEntity<List<AnswerDto>> getAnswers() {
    List<AnswerDto> answers = extractService.getAnswerDtos();
    log.debug(answers);
    if (!CollectionUtils.isEmpty(answers)) return ResponseEntity.ok(answers);
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/check/{questionNumber}and{option}")
  public ResponseEntity<Boolean> getCheckedAnswer(
      @PathVariable Integer questionNumber, @PathVariable String option) {
    Boolean answer = extractService.getSelectedAnswer(questionNumber, option);
    if (answer) return ResponseEntity.ok(Boolean.TRUE);
    return ResponseEntity.ok(Boolean.FALSE);
  }
  
  @PostMapping("/save")
  public ResponseEntity<Answer> save(@RequestBody Answer answer){
    final Answer save = extractService.save(answer);
    if (Objects.nonNull(save))
      return ResponseEntity.ok(save);
    return ResponseEntity.badRequest().build();
  }
}
