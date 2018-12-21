package com.iyzis.core.domain.enums;

public enum PaymentVendor {
    IYZICO("IYZICO");

    private String vendorName;

    PaymentVendor(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorName() {
        return this.vendorName;
    }
}
