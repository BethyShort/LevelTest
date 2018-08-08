package com.movileseller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movileseller.orderapp.layer.business.dto.impl.OrderDTO;
import com.movileseller.orderapp.layer.resources.cfg.AppConfig;

/**
 * Test intended to prove the order price service
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@PropertySource("classpath:service.properties")
public class ServicesOrderPriceTest {

	@Value("${orderPriceEndpoint}")
	private String orderPriceEndpoing;
	
	@Mock
	private OrderDTO orderDTO; 

	@Test
	public void isServiceRunning() {

		HttpUriRequest request = new HttpGet(orderPriceEndpoing);
		try {
			HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
			assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
			serializationTest();

		} catch (Exception ex) {
			fail("error executing isServiceRunning test. Exception catched");
		}
	}
	
	public void  serializationTest() throws ClientProtocolException, IOException{
		try {
		    HttpUriRequest request = new HttpGet(orderPriceEndpoing+"/"+orderDTO);
		    HttpResponse response = HttpClientBuilder.create().build().execute( request );
		    OrderDTO resource = retrieveResourceFromResponse(response, OrderDTO.class);
		    assertThat( orderDTO.getIdOrder(), Matchers.is( resource.getIdOrder()) );
		} catch (Exception ex) {
			fail("error executing isServiceRunning test. Exception catched");
		}
	}
	
	public static <T> T retrieveResourceFromResponse(HttpResponse response, Class<T> clazz) 
			  throws IOException {
			  
			    String jsonFromResponse = EntityUtils.toString(response.getEntity());
			    ObjectMapper mapper = new ObjectMapper()
			      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			    return mapper.readValue(jsonFromResponse, clazz);
			}
}
