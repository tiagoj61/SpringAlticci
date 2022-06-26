package tiago.j61.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErroMensageDto implements Serializable {
	private String mensagem;
	private int solicited;

	public ErroMensageDto(String mensagem, int solicited) {
		super();
		this.mensagem = mensagem;
		this.solicited = solicited;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getSolicited() {
		return solicited;
	}

	public void setSolicited(int solicited) {
		this.solicited = solicited;
	}

}
