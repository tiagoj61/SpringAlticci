package tiago.j61.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tiago.j61.dto.AlticciResponseDto;
import tiago.j61.dto.ErroMatrixMensageDto;
import tiago.j61.exception.SolicitedValueNegativeException;
import tiago.j61.facada.AlticciFacada;

@RestController
public class AlticciController {
	@Autowired
	private AlticciFacada alticciFacada;

	@ApiOperation(value = "Generate quadratic matrix from array and rotate", response = AlticciResponseDto.class, tags = "Alticci")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Value found", response = AlticciResponseDto.class),
			@ApiResponse(code = 400, message = "Array cannot generate a quadratic matrix!", response = ErroMatrixMensageDto.class),
			@ApiResponse(code = 500, message = "Internal server error!") })
	@PostMapping(path = "flipMatrix", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getValue(@PathVariable int request) {
		try {

			AlticciResponseDto response = alticciFacada.getValueOfIndex(1);
			return new ResponseEntity<>(response, HttpStatus.CREATED);

		} catch (SolicitedValueNegativeException e) {
			return new ResponseEntity<>(new ErroMatrixMensageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
