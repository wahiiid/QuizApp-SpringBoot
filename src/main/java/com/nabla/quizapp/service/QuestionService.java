package com.nabla.quizapp.service;

import com.nabla.quizapp.dao.QuestionDao;
import com.nabla.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public Question saveQuestion(Question question) {
        return questionDao.save(question);
    }


    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }


    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {

            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }
}
