package com.barnavarga.gerapex.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bvarga and created on 2020. 06. 25..
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderIntegrationTest
{
	private static final String URL_TEMPLATE = "http://localhost:%d/orders";
	private static final HttpHeaders HTTP_HEADERS = new HttpHeaders();

	static
	{
		HTTP_HEADERS.setContentType(MediaType.APPLICATION_JSON);
	}

	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;

	@Value("classpath:template/pharmacy-order.json")
	private Resource pharmacyOrder;

	@Test
	public void testCreatePharmacyOrder() throws IOException
	{
		final String url = String.format(URL_TEMPLATE, port);
		assertNotNull(url);

		final String payload = new String(FileCopyUtils.copyToByteArray(pharmacyOrder.getInputStream()), StandardCharsets.UTF_8);
		assertNotNull(payload);

		final HttpEntity<String> entity = new HttpEntity<>(payload, HTTP_HEADERS);
		final ResponseEntity<Void> responseEntity = restTemplate.postForEntity(url, entity, Void.class);
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());

		final ResponseEntity<String> fetchAllOrdersResponseEntity = restTemplate.getForEntity(url, String.class);
		assertNotNull(fetchAllOrdersResponseEntity);
		assertEquals(HttpStatus.OK, fetchAllOrdersResponseEntity.getStatusCode());
		assertNotNull(fetchAllOrdersResponseEntity.getBody());
		assertFalse(fetchAllOrdersResponseEntity.getBody().isEmpty());
	}
}
