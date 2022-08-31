package com.example.practicafragmentos20.model;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;

public class ModelBeneficiario extends RealmObject {
    //este es un objeto que contiene el modelo
    //contiene a BeneficiaryModel
    //modelo principal
    private RealmList<BeneficiaryModel> beneficiaryModelList;

    String otraVariable;

    public RealmList<BeneficiaryModel> getBeneficiaryModelList() {
        return beneficiaryModelList;
    }

    public void setBeneficiaryModelList(RealmList<BeneficiaryModel> beneficiaryModelList) {
        this.beneficiaryModelList = beneficiaryModelList;
    }

    public String getOtraVariable() {
        return otraVariable;
    }

    public void setOtraVariable(String otraVariable) {
        this.otraVariable = otraVariable;
    }
}
