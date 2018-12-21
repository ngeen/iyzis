package com.iyzis.apps.payment.facade;

import com.iyzis.apps.addon.facade.AddonFacade;
import com.iyzis.apps.billing.domain.BillingDTOBuilder;
import com.iyzis.apps.billing.domain.dto.BillingDTO;
import com.iyzis.apps.billing.facade.BillingFacade;
import com.iyzis.apps.customer.facade.CustomerFacade;
import com.iyzis.apps.payment.api.model.MakePaymentRequest;
import com.iyzis.apps.payment.api.model.PaymentResponse;
import com.iyzis.apps.payment.domain.PaymentDTOBuilder;
import com.iyzis.apps.payment.domain.PaymentModelManager;
import com.iyzis.apps.payment.domain.dto.PaymentDTO;
import com.iyzis.apps.payment.api.model.PaymentResultDTO;
import com.iyzis.apps.payment.domain.entity.Payment;
import com.iyzis.apps.payment.service.IVendorAdapter;
import com.iyzis.apps.payment.service.PaymentService;
import com.iyzis.apps.payment.service.PaymentVendorFactory;
import com.iyzis.apps.product.facade.ProductFacade;
import com.iyzis.apps.subscription.domain.SubscriptionDTOBuilder;
import com.iyzis.apps.subscription.domain.dto.SubscriptionDTO;
import com.iyzis.apps.subscription.facade.SubscriptionFacade;
import com.iyzis.core.facade.AbstractFacade;
import com.iyzis.core.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentFacade extends AbstractFacade<PaymentDTO, Payment> {

    private PaymentService paymentService;
    private PaymentModelManager paymentModelManager;

    @Autowired
    private CustomerFacade customerFacade;

    @Autowired
    private AddonFacade addonFacade;

    @Autowired
    private SubscriptionFacade subscriptionFacade;

    @Autowired
    private BillingFacade billingFacade;

    @Autowired
    private ProductFacade productFacade;


    @Autowired
    public PaymentFacade(PaymentService paymentService, PaymentModelManager paymentModelManager) {
        this.paymentService = paymentService;
        this.paymentModelManager = paymentModelManager;
    }

    public ResponseEntity<PaymentResponse> makePayment(MakePaymentRequest request) throws Exception {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setStatus(Boolean.FALSE);

        IVendorAdapter vendorAdapter = PaymentVendorFactory.create(request.getVendor());
        final PaymentResultDTO resultDTO = vendorAdapter.makePayment(request.getPaymentRequestDTO());

        if ("failure".equalsIgnoreCase(resultDTO.getStatus())) {
            throw new Exception("Error code: " + resultDTO.getErrorCode() + " Error Message: " + resultDTO.getErrorMessage());
        }


        // create subscription
        SubscriptionDTO subscriptionDTO = SubscriptionDTOBuilder.newInstance()
                .customer(request.getPaymentRequestDTO().getPaymentCustomerDTO().getId())
                .serviceId(request.getPaymentRequestDTO().getPaymentBasketItemDTO().getId())
                .serviceType(request.getServiceType())
                .period(request.getPeriod())
                .startDate(DateUtil.getNow())
                .endDate(DateUtil.getSubscriptionEndDate(DateUtil.getNow(), request.getPeriod())).build();
        subscriptionDTO = this.subscriptionFacade.create(subscriptionDTO);

        // create payment
        PaymentDTO paymentDTO = PaymentDTOBuilder.newInstance()
                .subscription(subscriptionDTO.getId())
                .vendor(request.getVendor())
                .amount(request.getPaymentRequestDTO().getPaymentBasketItemDTO().getPrice().doubleValue())
                .build();
        paymentDTO = this.create(paymentDTO);

        // create billing
        BillingDTO billingDTO = BillingDTOBuilder.newInstance()
                .payment(paymentDTO.getId())
                .subscription(paymentDTO.getSubscriptionId())
                .name(request.getPaymentRequestDTO().getPaymentCustomerDTO().getName())
                .lastName(request.getPaymentRequestDTO().getPaymentCustomerDTO().getSurname())
                .country(request.getPaymentRequestDTO().getPaymentBillingAddressDTO().getCountry())
                .city(request.getPaymentRequestDTO().getPaymentBillingAddressDTO().getCity())
                .address(request.getPaymentRequestDTO().getPaymentBillingAddressDTO().getAddress())
                .zipCode(request.getPaymentRequestDTO().getPaymentBillingAddressDTO().getZipCode())
                .build();
        this.billingFacade.create(billingDTO);

        paymentResponse.setMessage("Successful");
        paymentResponse.setStatus(Boolean.TRUE);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);

    }

    @Override
    public PaymentDTO create(PaymentDTO dto) {
        Payment payment = paymentModelManager.convert(dto);
        payment = paymentService.create(payment);
        return this.paymentModelManager.convert(payment);
    }

    @Override
    public void create(List<PaymentDTO> dtos) {
        List<Payment> payments = dtos.stream().map(paymentModelManager::convert).collect(Collectors.toList());
        paymentService.create(payments);
    }

    @Override
    public void update(PaymentDTO dto) {
    }

    @Override
    public void update(List<PaymentDTO> dtos) {
    }

    @Override
    public void delete(PaymentDTO dto) {
    }

    @Override
    public void delete(List<PaymentDTO> dtos) {
    }

    @Override
    public PaymentDTO find(Serializable id) {
        Optional<Payment> product = paymentService.find((String) id);
        return product.map(paymentModelManager::convert).get();
    }

    @Override
    public List<PaymentDTO> findAll() {
        Iterable<Payment> iterable = paymentService.findAll();
        List<PaymentDTO> paymentDTOS = new ArrayList<>();

        iterable.forEach(c -> paymentDTOS.add(paymentModelManager.convert(c)));
        return paymentDTOS;
    }

    public Long totalPaymentCount() {
        return this.paymentService.totalPaymentCount();
    }


}
