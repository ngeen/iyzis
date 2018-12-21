package com.iyzis.apps.dashboard.facade;


import com.iyzis.apps.customer.facade.CustomerFacade;
import com.iyzis.apps.payment.facade.PaymentFacade;
import com.iyzis.apps.subscription.facade.SubscriptionFacade;
import org.springframework.stereotype.Service;

@Service
public class DashboardFacade {

    private CustomerFacade customerFacade;
    private SubscriptionFacade subscriptionFacade;
    private PaymentFacade paymentFacade;

    public DashboardFacade(CustomerFacade customerFacade, SubscriptionFacade subscriptionFacade, PaymentFacade paymentFacade) {
        this.customerFacade = customerFacade;
        this.subscriptionFacade = subscriptionFacade;
        this.paymentFacade = paymentFacade;
    }

    public Long totalCustomerCount() {
        return this.customerFacade.totalCustomerCount();
    }

    public Long totalSubscriptionCount() {
        return this.subscriptionFacade.totalSubscriptionCount();
    }

    public Long totalPaymentCount() {
        return this.paymentFacade.totalPaymentCount();
    }
}
