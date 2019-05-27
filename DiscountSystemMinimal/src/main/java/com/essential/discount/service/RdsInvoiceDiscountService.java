package com.essential.discount.service;

public interface RdsInvoiceDiscountService
{

	Double getDiscount(double nonGroceryItemTotal, long diffDays, String userType);

}
