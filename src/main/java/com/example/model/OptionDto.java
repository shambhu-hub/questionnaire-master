package com.example.model;

import com.example.entity.Option;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OptionDto {
  private String a;
  private String b;
  private String c;
  private String d;

  public static OptionDto getOptionDto(Option option) {
    return OptionDto.builder()
        .a(option.getA())
        .b(option.getB())
        .c(option.getC())
        .d(option.getD())
        .build();
  }
}
