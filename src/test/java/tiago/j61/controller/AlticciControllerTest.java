package tiago.j61.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.RestTemplate;

import tiago.j61.dto.AlticciResponseDto;
import tiago.j61.dto.ErroMensageDto;
import tiago.j61.exception.SolicitedValueNegativeException;
import tiago.j61.helper.ReflectionHelper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AlticciControllerTest {

	private String url;
	private String port = "8080";

	@BeforeEach
	void begin() throws Exception {
		url = "http://localhost:" + port + "/";
	}

	@Test
	@DisplayName("Test negative value")
	@ExceptionHandler({ HttpClientErrorException.class })
	void negativeValue() {
		String path = ReflectionHelper.getPathFromMethod(AlticciController.class, 0);
		String uri = url + path;

		Map<String, String> params = new HashMap<String, String>();
		params.put("index", "-1");
		
		RestTemplate restTemplate = new RestTemplate();
		
		BadRequest response = Assertions.assertThrows(BadRequest.class, () -> {restTemplate.getForObject(uri, AlticciResponseDto.class, params);});
		
		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getRawStatusCode());

		assertNotNull(response.getResponseBodyAsString());
	}

	@Test
	@DisplayName("Test zero value")
	void zeroValue() {
		String path = ReflectionHelper.getPathFromMethod(AlticciController.class, 0);
		String uri = url + path;

		Map<String, String> params = new HashMap<String, String>();
		params.put("index", "0");

		RestTemplate restTemplate = new RestTemplate();
		AlticciResponseDto result = restTemplate.getForObject(uri, AlticciResponseDto.class, params);

		assertNotNull(result);
		assertEquals(result.getValueOriginal(), 0);
		assertEquals(result.getValueRetrived(), 0);
	}
	@Test
	@DisplayName("Test random value")
	void randomValue() {
		Integer index = new Random().nextInt(100) + 1;
		String path = ReflectionHelper.getPathFromMethod(AlticciController.class, 0);
		String uri = url + path;

		Map<String, String> params = new HashMap<String, String>();
		params.put("index", index.toString());

		RestTemplate restTemplate = new RestTemplate();
		AlticciResponseDto result = restTemplate.getForObject(uri, AlticciResponseDto.class, params);

		assertNotNull(result);
		assertEquals(result.getValueOriginal(), index);
	}

}