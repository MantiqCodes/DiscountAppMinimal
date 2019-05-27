package com.essential.discount;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DiscountControllerRestTemplateTest
{
	@Autowired
	TestRestTemplate testRestTemplate;

	// Formatter:off
	@Test
	public void whenUserTypeIsCustomerAndCustomerMembershipIsLessThanTwoYearsThenReturn5ForEvery100NonGroceryitemPriceTotal() throws Exception
	{
		ResponseEntity<Double> discount = testRestTemplate.getForEntity(
				"/getDiscount?customerType=Customer"
				+ "&memberShipAgeInDays=0"
				+ "&nonGroceryItemTotal=990", Double.class);
		Assertions.assertThat(discount.getBody()).isEqualTo(45.0);

	}
	@Test
	public void getDiscountByManualInputTest2() throws Exception
	{
		ResponseEntity<Double> discount = testRestTemplate.getForEntity(
				"/getDiscount?customerType=Customer"
				+ "&memberShipAgeInDays=732"
				+ "&nonGroceryItemTotal=990", Double.class);
		Assertions.assertThat(discount.getBody()).isEqualTo(49.5);

	}


	@Test
	public void getDiscountByManualInputTest3() throws Exception
	{
		ResponseEntity<Double> discount = testRestTemplate.getForEntity(
				"/getDiscount?customerType=Affiliate"
				+ "&memberShipAgeInDays=0"
				+ "&nonGroceryItemTotal=990", Double.class);
		Assertions.assertThat(discount.getBody()).isEqualTo(99.0);

	}


	@Test
	public void getDiscountByManualInputTest4() throws Exception
	{
		ResponseEntity<Double> discount = testRestTemplate.getForEntity(
				"/getDiscount?customerType=Employee"
				+ "&memberShipAgeInDays=0"
				+ "&nonGroceryItemTotal=990", Double.class);
		Assertions.assertThat(discount.getBody()).isEqualTo(297.0);

	}

	
	
	
}
