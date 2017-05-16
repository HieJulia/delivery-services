package com.cicero.deliveryservices.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.sender.MessageResponse;
import com.cicero.deliveryservices.service.DeliveryOrderService;
import com.cicero.deliveryservices.service.DeliveryOrderServiceAsync;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller que recebe as requisições da API.
 * 
 * @author cicero
 *
 */
@Api(value = "deliveryOrder", description = "Everything about your Delivery Order", produces = "application/json")
@RestController
@RequestMapping("/api")
public class DeliveryServiceController {

    @Autowired
    private DeliveryOrderService deliveryOrderService;

    @Autowired
    private DeliveryOrderServiceAsync deliveryOrderServiceAsync;

    
    @ApiOperation(value = "Find DeliveryOrder by ID", notes = "Returns DeliveryOrder by Identifier")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "ID of DeliveryOrder to return", required = true, dataType = "String", paramType = "path", defaultValue="1")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = DeliveryOrderForm.class),
            @ApiResponse(code = 500, message = "Failure")}) 
    @RequestMapping(method = RequestMethod.GET, path = "/delivery/{id}", produces = "application/json")
    public @ResponseBody DeliveryOrderForm searchDeliveryOrder(@PathVariable("id") String order) {
	return deliveryOrderService.findOrder(UUID.fromString(order));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create new DeliveryOrder", notes = "Creates new DeliveryOrder")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "Resource created") })
    @RequestMapping(method = RequestMethod.POST, path = "/delivery", consumes = "application/json")
    public @ResponseBody MessageResponse saveDeliveryOrder(
	    @RequestBody(required = true) @Valid DeliveryOrderForm deliveryOrderForm) {
	MessageResponse response = this.deliveryOrderServiceAsync.createOrUpdateOrder(deliveryOrderForm);
	return response;
    }

    @ApiOperation(value = "Find all DeliveryOrder", notes = "Returns all DeliveryOrder")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = DeliveryOrderForm.class),
            @ApiResponse(code = 500, message = "Failure")}) 
    @RequestMapping(method = RequestMethod.GET, path = "/delivery", produces = "application/json")
    public @ResponseBody List<DeliveryOrderForm> searchAllDeliveryOrder() {
	return deliveryOrderService.findAll();
    }

}
