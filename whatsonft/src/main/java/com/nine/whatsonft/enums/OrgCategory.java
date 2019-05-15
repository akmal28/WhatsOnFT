package com.nine.whatsonft.enums;

public enum OrgCategory {
    IMD("Ikatan Mahasiswa Departmen"), BO("Badan Otonom"), BSO("Badan Semi Otonom"), EKSEKUTIF("Eksekutif"), LEGISLATIF("Legislatif"), BOK("Badan Otonom Keagamaan"), KPD("Klub Peminatan Departemen");
    private String value;
    private OrgCategory(String value){
        this.value = value;
    }
}
