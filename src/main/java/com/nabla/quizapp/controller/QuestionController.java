package com.nabla.quizapp.controller;

import com.nabla.quizapp.entity.Question;
import com.nabla.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/saveQuestions")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion() {

        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }
}
