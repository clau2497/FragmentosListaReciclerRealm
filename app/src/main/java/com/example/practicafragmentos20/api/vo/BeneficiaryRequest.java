package com.example.practicafragmentos20.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BeneficiaryRequest {
    @Expose
    @SerializedName("idPersona")
    private long personId;
    @Expose
    @SerializedName("claveRol")
    private Integer roleKey;
//son de tipo set porque estamos consultando
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public void setRoleKey(Integer roleKey) {
        this.roleKey = roleKey;
    }



}
