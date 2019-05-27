package com.essential.discount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EssentialDiscountApplication.class)
public class SpringApplicatonTest
{

	@Test
	public void contextLoads()
	{
	}

	@Test
	public void EssentialDiscountApplicationStarts()
	{
		EssentialDiscountApplication.main(new String[] {});
	}
}