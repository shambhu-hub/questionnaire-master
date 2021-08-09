package com.example.model;

import com.example.entity.Question;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDto {
  private String question;
  private Integer questionNumber;
  private OptionDto options;

  public static QuestionDto getQuestionDto(Question question) {
    return QuestionDto.builder()
        .question(question.getQuestion())
        .questionNumber(question.getQuestionNumber())
        .options(OptionDto.getOptionDto(question.getOptions()))
        .build();
  }
}
