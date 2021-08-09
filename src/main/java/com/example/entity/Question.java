package com.example.entity;

import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {
	
  @JsonIgnore
  @Id @GeneratedValue private Integer id;
  private String question;
  private Integer questionNumber;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Option options;
}
