package br.com.qualify.service;

import java.util.List;

import br.com.qualify.domain.processo.Processo;

public interface ProcessoService {
	
	List<Processo> findAll();

	Processo addProcesso(Processo processo);

}
