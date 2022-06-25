package tiago.j61.dto;

import java.io.Serializable;

public class AlticciResponseDto implements Serializable {
	private int valueOriginal;
	private int valueRetrived;

	public int getValueOriginal() {
		return valueOriginal;
	}

	public void setValueOriginal(int valueOriginal) {
		this.valueOriginal = valueOriginal;
	}

	public int getValueRetrived() {
		return valueRetrived;
	}

	public void setValueRetrived(int valueRetrived) {
		this.valueRetrived = valueRetrived;
	}

}
