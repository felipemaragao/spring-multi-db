package br.com.qualify.domain.cliente;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	private Long codigo;
	private String nome;

}
