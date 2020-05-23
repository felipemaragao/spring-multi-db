package br.com.qualify.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import br.com.qualify.repository.cliente.ClienteRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses= ClienteRepository.class,
entityManagerFactoryRef = "clienteEntityManager")
public class ClienteDbConfig {
	
	@Bean 
	@ConfigurationProperties(prefix = "cliente.datasource")
	public DataSource clienteDataSource() {
		return DataSourceBuilder.create().build();
		
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean clienteEntityManager(
			EntityManagerFactoryBuilder builder, @Qualifier("clienteDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
			          .packages("br.com.qualify.domain.cliente")
			          .build();
	}

}
