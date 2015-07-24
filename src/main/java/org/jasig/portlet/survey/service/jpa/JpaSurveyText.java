/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portlet.survey.service.jpa;

import org.jasig.portlet.survey.mvc.service.JpaSurveyDataService;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.jasig.portlet.survey.service.dto.ITextGroup;

/**
 * The persistent class for the survey_text database table.
 * The combination of Key+Variant allows for describing text that can be referenced by any part of survey. The key nominally
 * names the grouping of text (text + alt + help) and the variant allows for discerning which of the combinations should be used.
 * 
 * @author chasegawa
 * @since 1.0
 */
@Entity
@Table(name = JpaSurveyDataService.TABLENAME_PREFIX + "TEXT")
public class JpaSurveyText implements ITextGroup, Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ALT_TEXT", nullable = true, unique = false)
    private String altText;
    
    @Column(name = "DEFINITION_TEXT", nullable = true, unique = false)
    private String definitionText;
    
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "HELP_TEXT", nullable = true, unique = false)
    private String helpText;
    
    @EmbeddedId
    private JpaSurveyTextPK id;
    
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "TEXT", nullable = true, unique = false)
    private String text;

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

    public JpaSurveyTextPK getId() {
        return id;
    }

    @Override
    public String getKey() {
        return id.getKey();
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getVariant() {
        return id.getVariant();
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

    public void setId(JpaSurveyTextPK id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    } 
}
