package com.iyzis.core.domain.enums;

public enum Period {

    INDEFINITE("INDEFINITE"),
    DAILY("DAILY"),
    WEEKLY("WEEKLY"),
    MONTHLY("MONTHLY"),
    ANNUALLY("ANNUALLY");

    private String period;

    Period(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return this.period;
    }
}
