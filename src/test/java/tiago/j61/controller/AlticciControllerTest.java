package tiago.j61.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import tiago.j61.dto.ErroMatrixMensageDto;
import tiago.j61.helper.ReflectionHelper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AlticciControllerTest {

	private String url;
	private String port = "8080";

	@BeforeEach
	void asd() throws Exception {
		url = "http://localhost:" + port + "/";
	}

	@Test
	@DisplayName("Test negative value")
	void negativeValue() {
		String path = ReflectionHelper.getPathFromMethod(AlticciController.class, 0);
		boolean isMatrixQuadratic = false;
		try {
			ResponseEntity<ErroMatrixMensageDto> response = new RestTemplate().postForEntity(url + path,
					MatrixHelper.generateMatrixRequestDto(isMatrixQuadratic), ErroMatrixMensageDto.class);

		} catch (RestClientResponseException response) {
			assertEquals(HttpStatus.BAD_REQUEST.value(), response.getRawStatusCode());
			assertNotNull(response.getResponseBodyAsString());

			JSONObject responseBody = assertDoesNotThrow(() -> new JSONObject(response.getResponseBodyAsString()));

			String fieldNameMatrix = ReflectionHelper.getAttributeName(ErroMatrixMensageDto.class, 1);

			JSONArray jsMatrixResponse = (JSONArray) assertDoesNotThrow(() -> responseBody.get(fieldNameMatrix));

			assertNotNull(jsMatrixResponse);

			assertEquals(jsMatrixResponse.length(), 0);

			String fieldNameMensage = ReflectionHelper.getAttributeName(ErroMatrixMensageDto.class, 0);

			assertNotNull(assertDoesNotThrow(() -> responseBody.get(fieldNameMensage)));
		}
	}

	@Test
	@DisplayName("Test random value")
	void randomValue() {
		String path = ReflectionHelper.getPathFromMethod(AlticciController.class, 0);
		boolean isMatrixQuadratic = false;
		try {
			ResponseEntity<ErroMatrixMensageDto> response = new RestTemplate().postForEntity(url + path,
					MatrixHelper.generateMatrixRequestWithoutArrrayDto(), ErroMatrixMensageDto.class);

		} catch (RestClientResponseException response) {
			assertEquals(HttpStatus.BAD_REQUEST.value(), response.getRawStatusCode());
			assertNotNull(response.getResponseBodyAsString());

			JSONObject responseBody = assertDoesNotThrow(() -> new JSONObject(response.getResponseBodyAsString()));

			String fieldNameMatrix = ReflectionHelper.getAttributeName(ErroMatrixMensageDto.class, 1);

			JSONArray jsMatrixResponse = (JSONArray) assertDoesNotThrow(() -> responseBody.get(fieldNameMatrix));

			assertNotNull(jsMatrixResponse);

			assertEquals(jsMatrixResponse.length(), 0);

			String fieldNameMensage = ReflectionHelper.getAttributeName(ErroMatrixMensageDto.class, 0);

			assertNotNull(assertDoesNotThrow(() -> responseBody.get(fieldNameMensage)));
		}
	}

}