package com.example.entity;

import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Setter
@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
	
  @JsonIgnore
  @Id @GeneratedValue private Integer id;
  private String ans;
  private String opt;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Question question;
}
