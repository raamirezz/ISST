package com.isst.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

@Configuration
public class JdbcConfiguration extends AbstractJdbcConfiguration {
    // No es necesario sobrescribir el método jdbcDialect()
    // ya que se usará la configuración predeterminada
    // proporcionada por Spring Data JDBC.
}
