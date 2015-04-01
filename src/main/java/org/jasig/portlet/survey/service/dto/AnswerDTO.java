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
package org.jasig.portlet.survey.service.dto;

import java.io.Serializable;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject(name = "AnswerDTO")
public class AnswerDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    @ApiObjectField
    private String altText;
    @ApiObjectField
    private String helpText;
    @ApiObjectField
    private long id;
    @ApiObjectField
    private String imgHeight;
    @ApiObjectField
    private String imgUrl;
    @ApiObjectField
    private String imgWidth;
    @ApiObjectField
    private String text;

    public String getAltText() {
        return altText;
    }

    public String getHelpText() {
        return helpText;
    }

    public long getId() {
        return id;
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
        return text;
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
