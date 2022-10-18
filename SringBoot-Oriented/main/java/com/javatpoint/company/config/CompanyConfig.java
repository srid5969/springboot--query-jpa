package com.javatpoint.company.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "companyentityManagerFactory",
						transactionManagerRef = "companyTransactionManager",
						basePackages = "com.javatpoint.company.repository")
public class CompanyConfig {
	@Primary
	@Bean(name = "companyDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource companyDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "companyentityManagerFactory")
	public LocalContainerEntityManagerFactoryBean companyentityManagerFactoryBean(
			EntityManagerFactoryBuilder builder,
			@Qualifier("companyDataSource") DataSource dataSource) {

		return builder.dataSource(dataSource).packages("com.javatpoint.company.model").persistenceUnit("db1")
				.build();
	}

	@Primary
	@Bean(name = "companyTransactionManager")
	public PlatformTransactionManager companyTransactionManager(
			@Qualifier("companyentityManagerFactory") EntityManagerFactory companyentityManagerFactory) {
		return new JpaTransactionManager(companyentityManagerFactory);
	}
}
