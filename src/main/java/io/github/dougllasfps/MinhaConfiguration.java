package io.github.dougllasfps;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class MinhaConfiguration {

    @Bean(name = "applicationName")
    public String applicationName(){
        return "Sistema de Vendas vinda do bean applicationName";
    }

    @Bean(name = "outraConfiguracao")
    public String outraConfiguracao(){
        return "Sistema de Vendas vinda do bean outraConfiguracao";
    }
}
