package com.openapi.naverdata.controller;

public enum ClientEnum {
    CLIENT_SECRET("q1skFqM7PY"),
    CLIENT_ID("H0ScqyAs1A275AWJrVuf");

    private String value;

    ClientEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
