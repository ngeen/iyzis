package com.iyzis.core.domain.enums;

public enum ServiceType {
    PRODUCT("PRODUCT"),
    ADDON("ADDON");

    private String serviceType;

    ServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceType() {
        return this.serviceType;
    }
}
