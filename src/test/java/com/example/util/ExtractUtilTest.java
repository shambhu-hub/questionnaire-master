package com.example.util;

import com.example.entity.Answer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class ExtractUtilTest {

  @Test
  void getAnswers() throws IOException {
    List<Answer> answers = ExtractUtil.getAnswers();
    System.out.println(answers);
  }
}
