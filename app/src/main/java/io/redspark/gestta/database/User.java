package io.redspark.gestta.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by weslleyneri on 22/06/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends SugarRecord {

    @JsonProperty("_id")
    private String gesttaId;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("company")
    private Company company;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("attempt")
    private Integer attempt;

    public User() {
    }

    public String getGesttaId() {
        return gesttaId;
    }

    public void setGesttaId(String gesttaId) {
        this.gesttaId = gesttaId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }
}
