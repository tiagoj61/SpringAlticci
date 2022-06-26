package tiago.j61.bo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tiago.j61.bo.AlticciBo;

@SpringBootTest
class AlticciBoTests {

	@Autowired
	private AlticciBo alticciBo;

	@Test
	@DisplayName("Teste get 0 from sequence")
	void getZeroFromIndex() {
		int value = alticciBo.getValueFromSequence(0);
		assertEquals(value, 0);
	}

	@Test
	@DisplayName("Teste get 1 from sequence")
	void getOneFromIndex() {
		int value = alticciBo.getValueFromSequence(1);
		assertEquals(value, 1);
	}

	@Test
	@DisplayName("Teste get 2 from sequence")
	void getTwoFromIndex() {
		int value = alticciBo.getValueFromSequence(2);
		assertEquals(value, 1);
	}

	@Test
	@DisplayName("Teste get value from sequence")
	void getValueFromIndex() {
		int index = 9;
		int value = alticciBo.getValueFromSequence(index);
		assertEquals(value, 7);
	}

}
