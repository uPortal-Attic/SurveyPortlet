package org.jasig.portlet.survey.service.dto;

/**
 * Text group is a set of text fields that are related. 
 * 
 * @author chasegawa
 * @since 1.0
 */
public interface ITextGroup {
    public String getAltText();

    public String getDefinitionText();

    public String getHelpText();

    public String getText();
}
