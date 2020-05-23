package br.com.qualify.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import br.com.qualify.repository.processo.ProcessoRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses= ProcessoRepository.class,
	                   entityManagerFactoryRef = "processoEntityManager")
public class ProcessoDbConfig {
	
	@Bean 
	@Primary
	@ConfigurationProperties(prefix = "processo.datasource")
	public DataSource processoDataSource() {
		return DataSourceBuilder.create().build();
		
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean processoEntityManager(
			EntityManagerFactoryBuilder builder, @Qualifier("processoDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
			          .packages("br.com.qualify.domain.processo")
			          .build();
	}

}
