package com.example.demo;

import com.example.demo.decorator.*;
import com.example.demo.delivery.*;
import com.example.demo.flowers.*;
import com.example.demo.payment.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;


@SpringBootTest
class FlowerApplicationTests {

	@Autowired
	private FlowerController controller;

	@Test
	public void testDelivery(){
		DHLDelivery delivery1 = new DHLDelivery();
		PostDelivery delivery2 = new PostDelivery();
		assert (delivery1.deliver(controller.getFlowers()) == 15);
		assert (delivery2.deliver(controller.getFlowers()) == 100);
	}

	@Test
	public void testPayment(){
		PayPalPayment payment1 = new PayPalPayment();
		CreditCardPayment payment2 = new CreditCardPayment();
		assert (payment1.pay(controller.getFlowers().stream().
				mapToDouble(Item::getPrice).
				sum()) == 153);
		assert (payment2.pay(controller.getFlowers().stream().
				mapToDouble(Item::getPrice).
				sum()) == 157.5);
	}

	@Test
	public void testDecorators(){
		Flower flower = new Flower(1L,50, FlowerColor.RED, 50, FlowerType.ROSE);
		Item ribbonFlower = new RibbonDecorator(flower);
		Item basketFlower = new BasketDecorator(flower);
		Item paperFlower = new PaperDecorator(flower);
		assert (ribbonFlower.getPrice() == 90);
		assert (Objects.equals(ribbonFlower.getDescription(),
				"Red Rose that costs 50.0 decorated with ribbon"));
		assert (basketFlower.getPrice() == 54);
		assert (Objects.equals(basketFlower.getDescription(),
				"Red Rose that costs 50.0 decorated with basket"));
		assert (paperFlower.getPrice() == 63);
		assert (Objects.equals(paperFlower.getDescription(),
				"Red Rose that costs 50.0 decorated with paper"));
	}
}
