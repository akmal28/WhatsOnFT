package com.nine.whatsonft.enums;

/**
 * Enum untuk kategori organisasi
 * @author Akmal Ramadhan Arifin
 * @version 16-05-2019
 */
public enum OrgCategory {
    IMD("Ikatan Mahasiswa Departmen"), BO("Badan Otonom"), BSO("Badan Semi Otonom"), EKSEKUTIF("Eksekutif"), LEGISLATIF("Legislatif"), BOK("Badan Otonom Keagamaan"), KPD("Klub Peminatan Departemen");
    private String value;

    /**
     * Method untuk value dari enum
     * @param value
     */
    private OrgCategory(String value){
        this.value = value;
    }
}
