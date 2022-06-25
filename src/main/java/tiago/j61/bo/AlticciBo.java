package tiago.j61.bo;

import org.springframework.stereotype.Service;

@Service
public class AlticciBo {

	public int getValueFromSequence(int index) {
		switch (index) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 1;
		default:
			int value = fristStage(index) + secondStage(index);
			return value;

		}
	}

	private int fristStage(int n) {
		int result = getValueFromSequence(n - 3);
		return result;
	}

	private int secondStage(int n) {
		int result = getValueFromSequence(n - 2);
		return result;
	}

}
