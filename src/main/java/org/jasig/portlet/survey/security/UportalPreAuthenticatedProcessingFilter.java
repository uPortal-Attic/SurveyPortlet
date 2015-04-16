/*
 * Copyright 2015 Jasig.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jasig.portlet.survey.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.jasig.portlet.survey.security.uportal.UPortalSecurityFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.preauth.j2ee.J2eePreAuthenticatedProcessingFilter;

/**
 *
 * @author mglazier
 */
public class UportalPreAuthenticatedProcessingFilter extends J2eePreAuthenticatedProcessingFilter {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(UportalPreAuthenticatedProcessingFilter.class);


    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        
        final UserDetails details = (UserDetails)session
                .getAttribute(UPortalSecurityFilter.AUTHENTICATION_TOKEN_KEY);
        return details;
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "this-value-is-ignored";
    }
}
