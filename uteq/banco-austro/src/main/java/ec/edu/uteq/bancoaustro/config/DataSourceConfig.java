package ec.edu.uteq.bancoaustro.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Value("${datasources.cuenca.url}")
    private String cuencaUrl;

    @Value("${datasources.cuenca.username}")
    private String cuencaUser;

    @Value("${datasources.cuenca.password}")
    private String cuencaPass;

    @Value("${datasources.cuenca.driver-class-name}")
    private String cuencaDriver;

    @Value("${datasources.quito.url}")
    private String quitoUrl;

    @Value("${datasources.quito.username}")
    private String quitoUser;

    @Value("${datasources.quito.password}")
    private String quitoPass;

    @Value("${datasources.quito.driver-class-name}")
    private String quitoDriver;

    @Bean(name = "cuencaDataSource")
    public DataSource cuencaDataSource() {
        return DataSourceBuilder.create()
                .url(cuencaUrl)
                .username(cuencaUser)
                .password(cuencaPass)
                .driverClassName(cuencaDriver)
                .build();
    }

    @Bean(name = "quitoDataSource")
    public DataSource quitoDataSource() {
        return DataSourceBuilder.create()
                .url(quitoUrl)
                .username(quitoUser)
                .password(quitoPass)
                .driverClassName(quitoDriver)
                .build();
    }
}