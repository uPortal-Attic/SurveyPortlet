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
package org.jasig.portlet.survey;

/**
 * Represents a state that a survey or part of a survey is currently in, such as <em>published</em> or <em>unpublished</em>
 * This list is intended to be comprehensive, but new states may be added in the future as needed.  
 * Survey data sources are afforded reasonable latitude as to when and how a surveyn enters into a state.  
 * View implementations vary as to how they represent a state to a user, or whether they represent it.
 *
 * @since 1.0
 * @author chasegawa
 */
public enum PublishedState {
	/**
	 * Default state of any new survey.
	 */
	UNPUBLISHED, 
	
	/**
	 * Once a survey moves to a published state, no further changes should be allowed to the content of the survey. A
	 * user's responses would always be linked to the id of a published survey.
	 */
	PUBLISHED;
}
