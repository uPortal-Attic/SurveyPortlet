package org.jasig.portlet.survey.service.dto;

import java.io.Serializable;

public class SurveyQuestionDTO implements Serializable {
    private static final long serialVersionUid = 1l;

    private int numAllowedAnswers;
    private int sequence;
    private QuestionDTO question;
    
    public int getNumAllowedAnswers() {
        return numAllowedAnswers;
    }

    public void setNumAllowedAnswers(int numAllowedAnswers) {
        this.numAllowedAnswers = numAllowedAnswers;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }
   
}
