package io.redspark.gestta.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orm.SugarRecord;

/**
 * Created by weslleyneri on 22/06/15.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Company extends SugarRecord{

    @JsonProperty("_id")
    private String gesttaId;

    @JsonProperty("name")
    private String name;

    public Company() {
    }

    public String getGesttaId() {
        return gesttaId;
    }

    public void setGesttaId(String gesttaId) {
        this.gesttaId = gesttaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
