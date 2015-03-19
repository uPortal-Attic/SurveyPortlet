package org.jasig.portlet.survey.service.dto;

import java.io.Serializable;

public class QuestionAnswerDTO implements Serializable {
    private static final long serialVersionUid = 1l;
    
    private AnswerDTO answer;
    
    public AnswerDTO getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerDTO answer) {
        this.answer = answer;
    }

}
