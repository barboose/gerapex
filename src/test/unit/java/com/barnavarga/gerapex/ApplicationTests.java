package com.barnavarga.gerapex;

import com.barnavarga.gerapex.controller.OrderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ApplicationTests
{
	@Autowired
	private OrderController<?, ?> orderController;

	@Test
	void contextLoads()
	{
		assertNotNull(orderController);
	}
}
