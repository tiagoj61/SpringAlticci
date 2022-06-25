package tiago.j61.facada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tiago.j61.dto.AlticciResponseDto;
import tiago.j61.exception.SolicitedValueNegativeException;
import tiago.j61.service.AlticciService;

@Service
public class AlticciFacada {
	@Autowired
	private AlticciService alticciService;

	public AlticciResponseDto getValueOfIndex(int index) throws SolicitedValueNegativeException {

		if (index < 0)
			throw new SolicitedValueNegativeException();

		AlticciResponseDto response = new AlticciResponseDto();

		response.setValueOriginal(index);
		response.setValueRetrived(alticciService.getValueFromSequence(index));

		return response;
	}
}
