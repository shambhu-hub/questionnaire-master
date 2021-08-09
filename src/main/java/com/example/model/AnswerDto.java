package com.example.model;

import com.example.entity.Answer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDto {

  private String question;
  private Integer questionNumber;
  private String ans;
  private String opt;

  public static AnswerDto getAnswerDto(Answer answer) {
    return AnswerDto.builder()
        .question(answer.getQuestion().getQuestion())
        .questionNumber(answer.getQuestion().getQuestionNumber())
        .ans(answer.getAns())
        .opt(answer.getOpt())
        .build();
  }
}
