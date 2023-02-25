package com.itproger.diplomsb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String shortref, fullref;

    public Reference() {
    }

    public Reference(String shortref, String fullref) {
        this.shortref = shortref;
        this.fullref = fullref;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortref() {
        return shortref;
    }

    public void setShortref(String shortref) {
        this.shortref = shortref;
    }

    public String getFullref() {
        return fullref;
    }

    public void setFullref(String fullref) {
        this.fullref = fullref;
    }
}
