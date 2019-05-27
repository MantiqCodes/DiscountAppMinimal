package com.essential.discount.util;

public enum UserTypes
{
	EMPLOYEE("Employee"), AFFILIATE("Affiliate"), CUSTOMER("Customer")

	;
	private final String userType;

	UserTypes(String userType)
	{
		this.userType = userType;
	}

	public String value()
	{
		return this.userType;
	}
}
