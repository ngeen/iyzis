package com.iyzis.apps.payment.service;

import com.iyzipay.Options;
import com.iyzipay.model.*;
import com.iyzipay.request.CreatePaymentRequest;
import com.iyzis.apps.payment.api.model.*;
import com.iyzis.apps.payment.config.IyzicoConfig;
import com.iyzis.core.utils.DateUtil;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;

public class IyzicoVendorAdapter extends Payment implements IVendorAdapter {
    private Options options;

    public IyzicoVendorAdapter() {
        IyzicoConfig iyzicoConfig = IyzicoConfig.getInstance();
        options = new Options();
        options.setApiKey(iyzicoConfig.getApiKey());
        options.setSecretKey(iyzicoConfig.getSecretKey());
        options.setBaseUrl(iyzicoConfig.getUrl());
    }

    @Override
    public PaymentResultDTO makePayment(PaymentRequestDTO paymentRequestDTO) throws Exception {
        CreatePaymentRequest paymentRequest = createPaymentRequest(paymentRequestDTO);
        Payment payment = Payment.create(paymentRequest, options);

        if (payment == null) {
            throw new Exception("Vendor Api Exception");
        }

        PaymentResultDTO resultDTO = new PaymentResultDTO();
        resultDTO
                .setErrorCode(payment.getErrorCode())
                .setConversationId(payment.getConversationId())
                .setErrorGroup(payment.getErrorGroup())
                .setErrorMessage(payment.getErrorMessage())
                .setStatus(payment.getStatus());

        return resultDTO;
    }

    private CreatePaymentRequest createPaymentRequest(PaymentRequestDTO paymentRequestDTO) {
        CreatePaymentRequest request = new CreatePaymentRequest();

        PaymentCard paymentCard = getPaymentCard(paymentRequestDTO.getPaymentCard());
        Address address = getBillingAddress(paymentRequestDTO.getPaymentBillingAddress());
        Buyer buyer = getBuyer(paymentRequestDTO.getPaymentCustomer(), paymentRequestDTO.getPaymentBillingAddress());
        BasketItem basketItem = getBusketItem(paymentRequestDTO.getPaymentBasketItem());

        request.setBasketItems(Collections.singletonList(basketItem));
        request.setPaymentCard(paymentCard);
        request.setBillingAddress(address);
        request.setShippingAddress(address);
        request.setBuyer(buyer);
        request.setLocale(Locale.EN.getValue());
        request.setConversationId(UUID.randomUUID().toString());
        request.setInstallment(1);
        request.setBasketId(UUID.randomUUID().toString());
        request.setPaymentChannel(PaymentChannel.WEB.name());
        request.setPaymentGroup(PaymentGroup.SUBSCRIPTION.name());
        request.setPrice(paymentRequestDTO.getPaymentBasketItem().getPrice());
        request.setPaidPrice(paymentRequestDTO.getPaymentBasketItem().getPrice());
        return request;
    }

    private PaymentCard getPaymentCard(PaymentCardDTO paymentCardDTO) {
        // Credit card info
        PaymentCard card = new PaymentCard();
        card.setCardNumber(paymentCardDTO.getCardNumber().replace(" ", ""));
        card.setRegisterCard(paymentCardDTO.getRegisterCard());
        card.setExpireYear(paymentCardDTO.getExpireYear());
        card.setExpireMonth(paymentCardDTO.getExpireMonth());
        card.setCvc(paymentCardDTO.getCvc());
        card.setCardHolderName(paymentCardDTO.getCardHolderName());
        return card;
    }

    private Address getBillingAddress(PaymentBillingAddressDTO paymentBillingAddressDTO) {
        // Address info
        Address address = new Address();
        address.setContactName(paymentBillingAddressDTO.getContactName());
        address.setCity(paymentBillingAddressDTO.getCity());
        address.setCountry(paymentBillingAddressDTO.getCountry());
        address.setAddress(paymentBillingAddressDTO.getAddress());
        address.setZipCode(paymentBillingAddressDTO.getZipCode());
        return address;
    }

    private Buyer getBuyer(PaymentCustomerDTO paymentCustomerDTO, PaymentBillingAddressDTO billingAddressDTO) {
        Buyer buyer = new Buyer();
        buyer.setId(paymentCustomerDTO.getId());
        buyer.setName(paymentCustomerDTO.getName());
        buyer.setSurname(paymentCustomerDTO.getSurname());
        buyer.setGsmNumber(paymentCustomerDTO.getGsmNumber());
        buyer.setEmail(paymentCustomerDTO.getEmail());
        buyer.setIdentityNumber(paymentCustomerDTO.getIdentityNumber() != null ? paymentCustomerDTO.getIdentityNumber() : "12345678901");//set dummy ıd no for non-local card users
        Date currentDate = new Date();
        buyer.setLastLoginDate(DateUtil.getFormattedDateAsString(currentDate));
        buyer.setRegistrationDate(paymentCustomerDTO.getRegistrationDate());
        buyer.setRegistrationAddress(billingAddressDTO.getAddress());
        buyer.setIp(paymentCustomerDTO.getIp());
        buyer.setCity(billingAddressDTO.getCity());
        buyer.setCountry(billingAddressDTO.getCountry());
        buyer.setZipCode(billingAddressDTO.getZipCode());
        return buyer;
    }

    private BasketItem getBusketItem(PaymentBasketItemDTO paymentBasketItemDTO) {
        BasketItem basketItem = new BasketItem();
        basketItem.setId(paymentBasketItemDTO.getId());
        basketItem.setName(paymentBasketItemDTO.getName());
        basketItem.setCategory1("SERVICE");
        basketItem.setCategory2("PRODUCT/ADDON");
        basketItem.setItemType(BasketItemType.PHYSICAL.name());
        basketItem.setPrice(paymentBasketItemDTO.getPrice());
        return basketItem;
    }
}
