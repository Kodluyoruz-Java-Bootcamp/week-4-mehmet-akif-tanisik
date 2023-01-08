package com.emlakcepte.repository;

import com.emlakcepte.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private static List<Payment> payments = new ArrayList<>();

    public void save(Payment payment) {
        payments.add(payment);
    }

    public List<Payment> findAll() {
        return payments;
    }
}
