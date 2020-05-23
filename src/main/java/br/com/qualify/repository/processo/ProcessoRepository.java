package br.com.qualify.repository.processo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.qualify.domain.processo.Processo;


public interface ProcessoRepository extends JpaRepository<Processo, Long>{
	

}
