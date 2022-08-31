package com.example.practicafragmentos20.domain.dto;

public class SearchClientDto {
    private String accountNumber;
    private String curp;
    private String nss;
    private String name;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getName () {
        return name;
    }

    public void setName(String nss) {
        this.name = name;
    }
}
