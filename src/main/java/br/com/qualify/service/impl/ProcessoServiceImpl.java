package br.com.qualify.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qualify.domain.cliente.Cliente;
import br.com.qualify.domain.processo.Processo;
import br.com.qualify.repository.cliente.ClienteRepository;
import br.com.qualify.repository.processo.ProcessoRepository;
import br.com.qualify.service.ProcessoService;

@Service
public class ProcessoServiceImpl implements ProcessoService {
	
	@Autowired
	private ProcessoRepository processoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Processo> findAll(){
		return this.processoRepository.findAll();
		
	}

	@Override
	public Processo addProcesso(Processo processo) {
		
		Cliente cliente = this.clienteRepository
				.findById(processo.getCodigoCliente())
				.orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
		processo.setNomeCliente(cliente.getNome());
		return this.processoRepository.save(processo);
		
	}

}
