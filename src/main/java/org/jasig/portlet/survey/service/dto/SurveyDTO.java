
package org.jasig.portlet.survey.service.dto;

import java.io.Serializable;
import java.util.Date;
import org.jasig.portlet.survey.SurveyState;

public class SurveyDTO implements Serializable {
    private static final long serialVersionUid = 1l;
    
    private String description;
    private long id;
    private String instructions;
    private Date lastUpdateDate;
    private String lastUpdateUser;
    private SurveyState status;
    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public SurveyState getStatus() {
        return status;
    }

    public void setStatus(SurveyState status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
