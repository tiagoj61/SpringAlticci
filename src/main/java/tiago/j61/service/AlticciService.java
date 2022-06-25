package tiago.j61.service;

import org.springframework.stereotype.Service;

@Service
public class AlticciService {

	public int getValueFromSequence(int index) {
		switch (index) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 1;
		default:
			int[] sequence = generateSequenceUntilIndex(index);
			return sequence[index + 1];
		}
	}

	public int[] generateSequenceUntilIndex(int index) {
		int[] alticci = new int[index];
		for (int i = 0; i < index; i++) {

		}
		return null;

	}
}
