package com.essential.discount.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.essential.discount.service.RdsInvoiceDiscountService;
import com.essential.discount.util.UserTypes;

import io.swagger.annotations.ApiOperation;

@RestController
public class DiscountController
{
	@Autowired
	RdsInvoiceDiscountService rdsInvoiceDiscountService;

	@ApiOperation(value = "Get discount  by  customer type , non-grocery items total , customer's membership age in days ")
	@RequestMapping(value = "getDiscount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

	public ResponseEntity<Double> getDiscountByManulaInput(
			@RequestParam(name = "customerType", defaultValue = "Employee", required = true) final String customerType,
			@RequestParam(name = "nonGroceryItemTotal", defaultValue = "999.0", required = true) final Double nonGroceryItemTotal,
			@RequestParam(name = "memberShipAgeInDays", defaultValue = "0731", required = true) final Integer memberShipAgeInDays)
	{

		Assert.isTrue(getCustomerTypeList().contains(customerType),"Invalid Customer Type; valid : Customer,Employee,Affiliate");
		double discount = rdsInvoiceDiscountService.getDiscount(nonGroceryItemTotal, memberShipAgeInDays, customerType);

		return new ResponseEntity<Double>(discount, HttpStatus.OK);
	}
	
	public List<String>getCustomerTypeList()
	{
		List<String>customerTypeList=new  ArrayList<String>();
		customerTypeList.add(UserTypes.EMPLOYEE.value());
		customerTypeList.add(UserTypes.AFFILIATE.value());
		customerTypeList.add(UserTypes.CUSTOMER.value());
		return customerTypeList;
		
	}

}
