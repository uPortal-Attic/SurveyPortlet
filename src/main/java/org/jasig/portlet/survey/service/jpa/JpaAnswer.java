/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portlet.survey.service.jpa;

import org.jasig.portlet.survey.mvc.service.JpaSurveyDataService;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * The persistent class for the survey_answer database table.
 * 
 * @author chasegawa
 * @since 1.0
 */
@Entity
@Table(name = JpaSurveyDataService.TABLENAME_PREFIX + "ANSWER")
public class JpaAnswer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ALT_TEXT", nullable = true)
    private String altText;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "HELP_TEXT", nullable = true)
    private String helpText;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private long id;

    @Column(name = "IMG_HEIGHT", nullable = true)
    private String imgHeight;
    
    @Column(name = "IMG_URL", nullable = true)
    private String imgUrl;
    
    @Column(name = "IMG_WIDTH", nullable = true)
    private String imgWidth;
    
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "TEXT", nullable = true)
    private String text;

    public String getAltText() {
        return this.altText;
    }

    public String getHelpText() {
        return helpText;
    }
    
    public long getId() {
        return this.id;
    }

    public String getImgHeight() {
        return imgHeight;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getImgWidth() {
        return imgWidth;
    }

    public String getText() {
        return this.text;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setImgHeight(String imgHeight) {
        this.imgHeight = imgHeight;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setImgWidth(String imgWidth) {
        this.imgWidth = imgWidth;
    }

    public void setText(String text) {
        this.text = text;
    }
}