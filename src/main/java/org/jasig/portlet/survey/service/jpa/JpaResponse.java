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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jasig.portlet.survey.mvc.service.JpaSurveyDataService;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * The persistent class for the survey_response database table.
 *
 * @author Benito J. Gonzalez <bgonzalez@unicon.net>
 * @since 1.0
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "JpaResponse.findBySurvey", query = "Select r from JpaResponse r where survey_id = ?1"),
    @NamedQuery(name = "JpaResponse.findByUserAndSurvey", query = "Select r from JpaResponse r where user = ?1 and survey_id = ?2")
})
@Table(name = JpaSurveyDataService.TABLENAME_PREFIX + "RESPONSE")
public class JpaResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @SequenceGenerator(
            name = JpaSurveyDataService.TABLENAME_PREFIX + "RESPONSE_GEN",
            sequenceName = JpaSurveyDataService.TABLENAME_PREFIX + "RESPONSE_SEQ",
            allocationSize = 5
    )
    @TableGenerator(
            name = JpaSurveyDataService.TABLENAME_PREFIX + "RESPONSE_GEN",
            pkColumnValue = JpaSurveyDataService.TABLENAME_PREFIX + "RESPONSE",
            allocationSize = 5
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = JpaSurveyDataService.TABLENAME_PREFIX + "RESPONSE_GEN")
    @Column(name = "ID", updatable = false)
    private long id;

    @Column(name = "USER", nullable = false)
    private String user;

    @Column(name = "LAST_UPDATED", nullable = false)
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn(name = "SURVEY_ID") //, table = JpaSurveyDataService.TABLENAME_PREFIX + "SURVEY")
    private JpaSurvey survey;

    @OneToMany(mappedBy = "id.jpaResponse", fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<JpaResponseAnswer> jpaResponseAnswers = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public JpaSurvey getSurvey() {
        return survey;
    }

    public Set<JpaResponseAnswer> getJpaResponseAnswers() {
        return Collections.unmodifiableSet(jpaResponseAnswers);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setSurvey(JpaSurvey survey) {
        this.survey = survey;
    }

    public void setJpaResponseAnswers(Set<JpaResponseAnswer> jpaResponseAnswers) {
        this.jpaResponseAnswers.clear();
        this.jpaResponseAnswers.addAll(jpaResponseAnswers);
    }

    public JpaResponseAnswer addJpaResponseAnswer(JpaResponseAnswer jpaResponseAnswer) {
        this.jpaResponseAnswers.add(jpaResponseAnswer);
        jpaResponseAnswer.getId().setJpaResponse(this);
        return jpaResponseAnswer;
    }

    public JpaResponseAnswer removeJpaResponseAnswer(JpaResponseAnswer jpaResponseAnswer) {
        this.jpaResponseAnswers.remove(jpaResponseAnswer);
        jpaResponseAnswer.getId().setJpaResponse(null);
        return jpaResponseAnswer;
    }

    @Override
    public String toString() {
        //return ToStringBuilder.reflectionToString(this);
        return new ToStringBuilder(this)
                .append("Id", id)
                .append("user", user)
                .append("answer count", jpaResponseAnswers.size()).toString();
    }
}
