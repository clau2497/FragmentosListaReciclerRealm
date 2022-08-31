package com.example.practicafragmentos20.api.vo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class GetBeneficiaryResponse {
    @SerializedName("listaBeneficiarios")
    @Expose
    private List<ListaBeneficiario> listaBeneficiarios = null;

    public List<ListaBeneficiario> getListaBeneficiarios() {
        return listaBeneficiarios;
    }

    public void setListaBeneficiarios(List<ListaBeneficiario> listaBeneficiarios) {
        this.listaBeneficiarios = listaBeneficiarios;
    }

    public static class ListaBeneficiario {

        @SerializedName("Nombre")
        @Expose
        private String nombre;
        @SerializedName("ApellidoPaterno")
        @Expose
        private String apellidoPaterno;
        @SerializedName("ApellidoMaterno")
        @Expose
        private String apellidoMaterno;
        @SerializedName("Edad")
        @Expose
        private Integer edad;
        @SerializedName("IdParentesco")
        @Expose
        private Integer idParentesco;
        @SerializedName("Parentesco")
        @Expose
        private String parentesco;
        @SerializedName("Porcentaje")
        @Expose
        private Integer porcentaje;
        @SerializedName("CURP")
        @Expose
        private String curp;
        @SerializedName("RFC")
        @Expose
        private String rfc;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidoPaterno() {
            return apellidoPaterno;
        }

        public void setApellidoPaterno(String apellidoPaterno) {
            this.apellidoPaterno = apellidoPaterno;
        }

        public String getApellidoMaterno() {
            return apellidoMaterno;
        }

        public void setApellidoMaterno(String apellidoMaterno) {
            this.apellidoMaterno = apellidoMaterno;
        }

        public Integer getEdad() {
            return edad;
        }

        public void setEdad(Integer edad) {
            this.edad = edad;
        }

        public Integer getIdParentesco() {
            return idParentesco;
        }

        public void setIdParentesco(Integer idParentesco) {
            this.idParentesco = idParentesco;
        }

        public String getParentesco() {
            return parentesco;
        }

        public void setParentesco(String parentesco) {
            this.parentesco = parentesco;
        }

        public Integer getPorcentaje() {
            return porcentaje;
        }

        public void setPorcentaje(Integer porcentaje) {
            this.porcentaje = porcentaje;
        }

        public String getCurp() {
            return curp;
        }

        public void setCurp(String curp) {
            this.curp = curp;
        }

        public String getRfc() {
            return rfc;
        }

        public void setRfc(String rfc) {
            this.rfc = rfc;
        }

    }



}
