package com.nine.whatsonft.enums;

/**
 * Enum untuk kategori event non-akademis
 * @author Akmal Ramadhan Arifin
 * @version 16-05-2019
 */
public enum NonAcadEventCategory {
    Olahraga("Olahraga"), Seni("Seni"), IPTEK("IPTEK"), Pengmas("Pengabdian Masyarakat"), Rohani("Rohani"), Others("Lainnya");
    private String value;

    /**
     * Method untuk value dari enum
     * @param value
     */
    NonAcadEventCategory(String value) {
        this.value = value;
    }
}
