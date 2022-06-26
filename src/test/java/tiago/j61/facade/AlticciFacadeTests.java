package tiago.j61.facade;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tiago.j61.exception.SolicitedValueNegativeException;
import tiago.j61.facade.AlticciFacade;

@SpringBootTest
class AlticciFacadeTests {

	@Autowired
	private AlticciFacade alticciFacade;

	@Test
	@DisplayName("Teste for negative values")
	void negativeValue() {
		assertThrows(SolicitedValueNegativeException.class, () -> alticciFacade.getValueOfIndex(-1));
	}

	@Test
	@DisplayName("Teste for random value")
	void randomValue() {
		int index = new Random().nextInt(10) + 1;
		assertDoesNotThrow(() -> alticciFacade.getValueOfIndex(index));
	}

}
