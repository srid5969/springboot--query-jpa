package com.javatpoint.user.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "userentityManagerFactory",
						transactionManagerRef = "userTransactionManager", 
						basePackages = "com.javatpoint.user.repository")
public class UserConfig {
	@Bean(name = "userDataSource")
	@ConfigurationProperties(prefix = "db2.datasource")
	public DataSource userDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "userentityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
			EntityManagerFactoryBuilder builder,
			@Qualifier("userDataSource") DataSource dataSource) {

		return builder.dataSource(dataSource).
				packages("com.javatpoint.user.model")
				.persistenceUnit("db1")
				.build();
	}

	@Bean(name = "userTransactionManager")
	public PlatformTransactionManager userTransactionManager(
			@Qualifier("userentityManagerFactory") EntityManagerFactory userentityManagerFactory) {
		return new JpaTransactionManager(userentityManagerFactory);
	}
}
