package br.com.qualify.domain.processo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "processo")
public class Processo {
	
	@Id
	private Long codigo;
	private String numero;
	
	@Column(name = "nome_cliente")
	private String nomeCliente;
	
	@Transient
	private Long codigoCliente;
	

}
