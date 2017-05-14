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
import com.cicero.deliveryservices.sender.MessageSender;
import com.cicero.deliveryservices.service.DeliveryOrderService;

@RestController
@RequestMapping("/api")
public class DeliveryServiceController {
	
	@Autowired
	private DeliveryOrderService deliveryOrderService;
	
	@Autowired
	private MessageSender messageSender;
	
	@RequestMapping(method = RequestMethod.GET, path="/delivery/{id}", produces = "application/json")
	public @ResponseBody DeliveryOrder searchDeliveryOrder(@PathVariable("id") String order) {
		return this.deliveryOrderService.findOrder(UUID.fromString(order));
	}
	
	@RequestMapping(method = RequestMethod.POST, path="/delivery", consumes = "application/json")
	public @ResponseBody DeliveryOrder saveDeliveryOrder(@RequestBody(required = true) @Valid DeliveryOrder address) {
		messageSender.sendMessage(address);
//		return this.deliveryOrderService.createOrUpdateOrder(address);
		return address;
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/delivery", produces = "application/json")
	public @ResponseBody List<DeliveryOrder> searchAllDeliveryOrder() {
		return this.deliveryOrderService.findAll();
	}

}
