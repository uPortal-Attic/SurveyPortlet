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
package org.jasig.portlet.survey.mvc.summary;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Map;

/**
 * Survey summary portlet. Simple delivery of AngularJS app.
 *
 * @since  1.0
 */
@Controller
@RequestMapping("VIEW")
public final class SummaryController {

    private final Log logger = LogFactory.getLog(getClass());
    private static final String VIEW_NAME =  "summary";

    @RenderMapping
    public ModelAndView showMainView(final RenderRequest request, final RenderResponse response) {
        @SuppressWarnings("unchecked")
        final Map<String,String> userInfo =
                (Map<String,String>) request.getAttribute(PortletRequest.USER_INFO);

        final ModelAndView mav = new ModelAndView(VIEW_NAME);
        mav.addObject("username", request.getRemoteUser());
        mav.addObject("displayName", userInfo.get("displayName"));
        mav.addObject("emailAddress", userInfo.get("mail"));
        return mav;
    }

    @ActionMapping
    public void doAction() {
        // no-op action mapping to prevent accidental calls to this URL from
        // crashing the portlet
    }

}
