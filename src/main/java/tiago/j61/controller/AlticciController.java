package tiago.j61.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tiago.j61.dto.AlticciResponseDto;
import tiago.j61.dto.ErroMensageDto;
import tiago.j61.exception.SolicitedValueNegativeException;
import tiago.j61.facade.AlticciFacade;

@RestController
public class AlticciController {
	@Autowired
	private AlticciFacade alticciFacade;

	@ApiOperation(value = "Get value from Alticci sequence by index", response = AlticciResponseDto.class, tags = "Alticci")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Value found", response = AlticciResponseDto.class),
			@ApiResponse(code = 400, message = "Value not valid", response = ErroMensageDto.class),
			@ApiResponse(code = 500, message = "Internal server error!") })
	@GetMapping(path = "alticci/{index}")
	public ResponseEntity<?> getValue(@PathVariable int index) {
		try {

			AlticciResponseDto response = alticciFacade.getValueOfIndex(index);

			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (SolicitedValueNegativeException e) {
			return new ResponseEntity<>(new ErroMensageDto(e.getMessage(), index), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
