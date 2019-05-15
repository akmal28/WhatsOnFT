package com.nine.whatsonft.enums;

public enum NonAcadEventCategory {
    Olahraga("Olahraga"), Seni("Seni"), IPTEK("IPTEK"), Pengmas("Pengabdian Masyarakat"), Rohani("Rohani"), Others("Lainnya");
    private String value;

    NonAcadEventCategory(String value) {
        this.value = value;
    }
}
