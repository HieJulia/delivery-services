package com.cicero.deliveryservices.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cicero.deliveryservices.domain.DeliveryOrder;
import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.sender.MessageResponse;
import com.cicero.deliveryservices.service.DeliveryOrderRedisService;
import com.cicero.deliveryservices.service.DeliveryOrderService;
import com.cicero.deliveryservices.service.DeliveryOrderServiceAsync;

@RestController
@RequestMapping("/api")
public class DeliveryServiceController {

	@Autowired
	private DeliveryOrderService deliveryOrderService;

	@Autowired
	private DeliveryOrderServiceAsync deliveryOrderServiceAsync;
	
	@RequestMapping(method = RequestMethod.GET, path = "/delivery/{id}", produces = "application/json")
	public @ResponseBody DeliveryOrderForm searchDeliveryOrder(@PathVariable("id") String order) {
		return deliveryOrderService.findOrder(UUID.fromString(order));
	}

	@RequestMapping(method = RequestMethod.POST, path = "/delivery", consumes = "application/json")
	public @ResponseBody MessageResponse saveDeliveryOrder(
			@RequestBody(required = true) @Valid DeliveryOrderForm deliveryOrderForm) {
		MessageResponse response = this.deliveryOrderServiceAsync.createOrUpdateOrder(deliveryOrderForm);
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/delivery", produces = "application/json")
	public @ResponseBody List<DeliveryOrderForm> searchAllDeliveryOrder() {
		return deliveryOrderService.findAll();
	}

}
