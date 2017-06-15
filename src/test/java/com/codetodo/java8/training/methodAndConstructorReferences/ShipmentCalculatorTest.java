package com.codetodo.java8.training.methodAndConstructorReferences;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;

public class ShipmentCalculatorTest {

	private ShipmentCalculator shipmentCalculator;
	
	@Before
	public void setup() {
		shipmentCalculator = new ShipmentCalculator();
	}
	
	@Test
	public void callCalculateOnShipmentsUsingAnonymousClass() {
		List<Shipment> shipments = new ArrayList<Shipment>();
		
		List<Double> result = shipmentCalculator.calculateOnShipments(shipments, new Function<Shipment, Double>() {

			@Override
			public Double apply(Shipment s) {
				return s.calculateWeight();
			}
			
		});
		
		assertNotNull(result);
	}
	
	@Test
	public void callCalculateOnShipmentsUsingLambdaExpression() {
		List<Shipment> shipments = new ArrayList<Shipment>();
		
		List<Double> result = shipmentCalculator.calculateOnShipments(shipments, (s) -> s.calculateWeight());
		
		assertNotNull(result);
	}
	
	@Test
	public void callCalculateOnShipmentsUsingMethodReference() {
		List<Shipment> shipments = new ArrayList<Shipment>();
		
		List<Double> result = shipmentCalculator.calculateOnShipments(shipments, Shipment::calculateWeight);
		
		assertNotNull(result);
	}

}
