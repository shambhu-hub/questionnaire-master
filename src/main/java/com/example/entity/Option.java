package com.example.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Option {

  @JsonIgnore
  @Id @GeneratedValue private Integer id;
  private String a;
  private String b;
  private String c;
  private String d;
}
