package org.jasig.portlet.survey.mvc;

import java.io.Serializable;

import org.jasig.portlet.survey.service.dto.ITextGroup;

public class TextGroupImpl implements ITextGroup, Serializable {
    private static final long serialVersionUID = 1L;
    private String altText;
    private String definitionText;
    private String helpText;
    private String key;
    private String text;
    private String variant;

    @Override
    public String getAltText() {
        return altText;
    }

    @Override
    public String getDefinitionText() {
        return definitionText;
    }

    @Override
    public String getHelpText() {
        return helpText;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getVariant() {
        return variant;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public void setDefinitionText(String definitionText) {
        this.definitionText = definitionText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }
}
