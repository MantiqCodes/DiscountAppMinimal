package com.essential.discount.service;

import org.springframework.stereotype.Service;

import com.essential.discount.util.UserTypes;

@Service
public class RdsInvoiceDiscountServiceImpl implements RdsInvoiceDiscountService
{

	@Override
	public Double getDiscount(double nonGroceryItemTotal, long memberShipAgeInDays, String userType)
	{
		long daysInTwoYears = 365 * 2;
		Double discount = 0.0;
		if (UserTypes.EMPLOYEE.value().equals(userType))
		{
			discount = nonGroceryItemTotal * 30 / 100;
		} else if (UserTypes.AFFILIATE.value().equals(userType))
		{
			discount = nonGroceryItemTotal * 10 / 100;

		} else if (UserTypes.CUSTOMER.value().equals(userType))
		{
			// if the customer's membership is older than 2 years OR non-groceryy item total
			// > $ 100
			if (memberShipAgeInDays > daysInTwoYears)
			{
				discount = nonGroceryItemTotal * 5 / 100;
			} else if (nonGroceryItemTotal >= 100)
			{
				double discountableTotatl = nonGroceryItemTotal - nonGroceryItemTotal % 100;
				discount = discountableTotatl * 5 / 100;
			}
		}
		return discount;
	}

}
