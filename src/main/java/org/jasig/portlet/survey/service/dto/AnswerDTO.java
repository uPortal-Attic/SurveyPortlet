package org.jasig.portlet.survey.service.dto;

import java.io.Serializable;

public class AnswerDTO implements Serializable {
    private static final long serialVersionUid = 1l;
    
    private String altText;
    private long id;
    private String text;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
