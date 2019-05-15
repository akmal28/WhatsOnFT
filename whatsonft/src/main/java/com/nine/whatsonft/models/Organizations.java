package com.nine.whatsonft.models;

import com.nine.whatsonft.enums.OrgCategory;

public class Organizations {
    private int id;
    private String name;
    private OrgCategory category;

    public Organizations(int id, String name, OrgCategory category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrgCategory getCategory() {
        return category;
    }

    public void setCategory(OrgCategory category) {
        this.category = category;
    }
}
