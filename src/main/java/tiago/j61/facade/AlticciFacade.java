package tiago.j61.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tiago.j61.bo.AlticciBo;
import tiago.j61.dto.AlticciResponseDto;
import tiago.j61.exception.SolicitedValueNegativeException;

@Service
public class AlticciFacade {
	@Autowired
	private AlticciBo alticciService;

	public AlticciResponseDto getValueOfIndex(int index) throws SolicitedValueNegativeException {

		if (index < 0)
			throw new SolicitedValueNegativeException();

		AlticciResponseDto response = new AlticciResponseDto();

		response.setValueOriginal(index);
		response.setValueRetrived(alticciService.getValueFromSequence(index));

		return response;
	}
}
