package tiago.j61.facada;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlticciFacadaTests {

	@Autowired
	private AlticciFacada matrixFacada;

	@Test
	@DisplayName("Teste for negative values")
	void negativeValue() {

	}

	@Test
	@DisplayName("Teste for random value")
	void randomValue() {
	}

}
