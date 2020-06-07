package com.zhusl.springcloud.service;


import com.zhusl.springcloud.entities.Payment;

public interface PaymentService {

	public int create(Payment payment);

	public Payment getPaymentById(Long id);

}
