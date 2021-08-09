package com.example.util;

import com.example.entity.Answer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExtractUtil {
  public static List<Answer> getAnswers() throws IOException {
    final File file = ResourceUtils.getFile("classpath:data.json");
    List<Answer> answers = new ObjectMapper().readValue(file, new TypeReference<List<Answer>>() {});
    return answers;
  }
}
