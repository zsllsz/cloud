package com.zhusl.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zhusl.springcloud.common.JsonResult;
import com.zhusl.springcloud.entities.Payment;
import com.zhusl.springcloud.loadBalance.LoadBalancer;

@RestController
@RequestMapping("/consumer")
public class OrderController {
	
//	private static final String PAYMENT_URL = "http://localhost:8001";
	private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
	
	@Autowired
	private LoadBalancer loadBalancer;
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/payment/create")
	public JsonResult<Payment> create(Payment payment){
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, JsonResult.class);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/payment/get/{id}")
	public JsonResult<Payment> getPayment(@PathVariable("id") Long id){
		return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, JsonResult.class);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/payment/get/info/{id}")
	public JsonResult<Payment> getPaymentInfo(@PathVariable("id") Long id){
		return restTemplate.getForEntity(PAYMENT_URL + "/payment/" + id, JsonResult.class).getBody();
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/payment/get/lb/{id}")
	public JsonResult<Payment> getPaymentlb(@PathVariable("id") Long id){
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		if (instances.isEmpty()) {
			return null;
		}
		ServiceInstance service = loadBalancer.instance(instances);
		return restTemplate.getForEntity(service.getUri() + "/payment/" + id, JsonResult.class).getBody();
	}

}
