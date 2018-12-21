package com.iyzis.apps.payment.config;

public class IyzicoConfig {
    private String apiKey = "sandbox-2di9ls6XlpDdbso7Vo1c4sKrEkPFpBxv";
    private String secretKey = "sandbox-FC4tpvt7Ay7H8nNfvSpTvZ72aDbGpk0w";
    private String url = "https://sandbox-api.iyzipay.com";

    private IyzicoConfig() {}

    private static class IyzicoConfigHolder {
        private static final IyzicoConfig INSTANCE = new IyzicoConfig();
    }

    public static IyzicoConfig getInstance() {
        return IyzicoConfigHolder.INSTANCE;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public String getUrl() {
        return this.url;
    }
}
