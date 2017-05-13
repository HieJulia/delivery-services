package com.cicero.deliveryservices;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cicero.deliveryservices.domain.DeliveryOrder;
import com.cicero.deliveryservices.repository.DeliveryOrderRepository;
import com.cicero.deliveryservices.service.DeliveryOrderService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DeliveryServicesApplication.class)
public class DeliveryServicesApplicationTests {
	
	@Autowired
	private DeliveryOrderService deliveryOrderService;

	@Test
	public void shouldSaveDeliveryOrder() {
		
		DeliveryOrder deliveryOrder =  new DeliveryOrderBuilder().sampleDeliveryOrderBuilder();
		
		deliveryOrder = this.deliveryOrderService.createOrUpdateOrder(deliveryOrder);
		
		assertNotNull(deliveryOrder);
		
	}
	

}
