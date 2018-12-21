package com.iyzis.apps.payment.api.model;

import lombok.Data;

@Data
public class PaymentResultDTO {
    private String status;
    private String errorCode;
    private String errorMessage;
    private String errorGroup;
    private String conversationId;

    public String getStatus() {
        return status;
    }

    public PaymentResultDTO setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public PaymentResultDTO setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public PaymentResultDTO setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public String getErrorGroup() {
        return errorGroup;
    }

    public PaymentResultDTO setErrorGroup(String errorGroup) {
        this.errorGroup = errorGroup;
        return this;
    }

    public String getConversationId() {
        return conversationId;
    }

    public PaymentResultDTO setConversationId(String conversationId) {
        this.conversationId = conversationId;
        return this;
    }
}
