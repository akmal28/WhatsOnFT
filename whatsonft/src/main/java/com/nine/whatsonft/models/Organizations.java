package com.nine.whatsonft.models;

import com.nine.whatsonft.enums.OrgCategory;

/**
 * Class ini merupakan model untuk Organization
 * @author Akmal Ramadhan Arifin
 * @version 16-05-2019
 */
public class Organizations {
    private int id;
    private String name;
    private OrgCategory category;

    /**
     * Constructor untuk class Organization
     * @param id
     * @param name
     * @param category
     */
    public Organizations(int id, String name, OrgCategory category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    /**
     * Method getter untuk mendapatkan ID organisasi
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Method setter untuk mengubah ID organisasi
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method getter untuk mendapatkan nama organisasi
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Method setter untuk mengubah nama organisasi
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getter untuk mendapatkan kategori organisasi
     * @return
     */
    public OrgCategory getCategory() {
        return category;
    }

    /**
     * Method setter untuk mengubah kategori organisasi
     * @param category
     */
    public void setCategory(OrgCategory category) {
        this.category = category;
    }
}
