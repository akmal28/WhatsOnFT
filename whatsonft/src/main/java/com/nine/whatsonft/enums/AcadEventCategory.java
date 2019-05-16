package com.nine.whatsonft.enums;

/**
 * Enum untuk kategori event akademis
 * @author Akmal Ramadhan Arifin
 * @version 16-05-2019
 */
public enum AcadEventCategory {
    Training("Training"), Asistensi("Asistensi");
    private String value;

    /**
     * Method untuk value dari enum
     * @param value
     */
    AcadEventCategory(String value) {
        this.value = value;
    }
}
