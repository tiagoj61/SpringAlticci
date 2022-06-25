package tiago.j61.bo;

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
		//System.out.println(alticciBo.getValueFromSequence(0));
	}

	@Test
	@DisplayName("Teste get value from sequence")
	void getValueFromIndex() {
		System.out.println(alticciBo.getValueFromSequence(3));
		System.out.println(alticciBo.getValueFromSequence(4));
		System.out.println(alticciBo.getValueFromSequence(5));
		System.out.println(alticciBo.getValueFromSequence(6));
		System.out.println(alticciBo.getValueFromSequence(7));
		System.out.println(alticciBo.getValueFromSequence(8));
		System.out.println(alticciBo.getValueFromSequence(9));
		System.out.println(alticciBo.getValueFromSequence(10));
	}

}
