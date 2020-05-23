package br.com.qualify.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.qualify.domain.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
