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
