package com.example.finalprojectapp.data.entities;

public class PersistKeyValue {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public PersistKeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
