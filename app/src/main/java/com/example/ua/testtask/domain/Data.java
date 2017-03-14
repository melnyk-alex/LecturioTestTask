package com.example.ua.testtask.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


/**
 *
 */
public class Data {

    @SerializedName("questions")
    @Expose
    private List<Question> questions = null;
    @SerializedName("questionsCnt")
    @Expose
    private Integer questionsCnt;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Integer getQuestionsCnt() {
        return questionsCnt;
    }

    public void setQuestionsCnt(Integer questionsCnt) {
        this.questionsCnt = questionsCnt;
    }

}