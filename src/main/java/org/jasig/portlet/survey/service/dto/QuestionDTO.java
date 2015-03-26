
package org.jasig.portlet.survey.service.dto;

import java.io.Serializable;
import java.util.List;
import org.jasig.portlet.survey.PublishedState;

public class QuestionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String altText;
    private long id;
    private List<QuestionAnswerDTO> questionAnswers;
    private String text;
    private PublishedState status;
    
    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<QuestionAnswerDTO> getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(List<QuestionAnswerDTO> jpaQuestionAnswers) {
        this.questionAnswers = jpaQuestionAnswers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PublishedState getStatus() {
        return status;
    }

    public void setStatus(PublishedState status) {
        this.status = status;
    }
}
