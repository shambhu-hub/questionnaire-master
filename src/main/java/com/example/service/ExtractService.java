package com.example.service;

import com.example.entity.Answer;
import com.example.entity.Question;
import com.example.model.AnswerDto;
import com.example.model.QuestionDto;
import com.example.repository.AnswerRepository;
import com.example.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExtractService {

  @Autowired private QuestionRepository questionRepository;
  @Autowired private AnswerRepository answerRepository;

  public List<QuestionDto> getQuestions() {
    List<Question> questions = questionRepository.findAll();
    return questions.parallelStream().map(QuestionDto::getQuestionDto).collect(Collectors.toList());
  }

  public List<AnswerDto> getAnswerDtos() {
    List<Answer> answers = answerRepository.findAll();
    return answers.parallelStream().map(AnswerDto::getAnswerDto).collect(Collectors.toList());
  }

  public Boolean getSelectedAnswer(Integer questionNumber, String option) {

    final Optional<AnswerDto> first =
        getAnswerDtos().stream()
            .filter(answerDto -> answerDto.getQuestionNumber().equals(questionNumber))
            .findFirst();
    return first.map(answerDto -> answerDto.getOpt().equalsIgnoreCase(option)).orElse(false);
  }
  
  public Answer save(Answer answer){
	    return answerRepository.saveAndFlush(answer);
	  }
}
