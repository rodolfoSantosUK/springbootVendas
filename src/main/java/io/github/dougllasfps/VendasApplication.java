package io.github.dougllasfps;

import io.github.dougllasfps.domain.entity.Cliente;
import io.github.dougllasfps.repositorio.ClientesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepositorio clientesRepositorio) {
        return args -> {
            clientesRepositorio.salvar(new Cliente("Rodolfo"));
            clientesRepositorio.salvar(new Cliente("Luiz"));

            System.out.println(" Obter todos clientes ");
            List<Cliente> todosClientes = clientesRepositorio.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println(" Atualizar ");
            todosClientes.forEach(cliente -> {
                cliente.setNome(cliente.getNome() + " atualizado");
                clientesRepositorio.atualizar(cliente);
            });

            System.out.println(" Obter todos clientes ");
            todosClientes = clientesRepositorio.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println(" Deletar ");
            clientesRepositorio.deletar(1);

            System.out.println(" Obter todos clientes ");
            todosClientes = clientesRepositorio.obterTodos();
            todosClientes.forEach(System.out::println);

        };
    }

    @Autowired
    @Qualifier("outraConfiguracao")
    private String applicationName;

    @Value("${ambiente}")
    private String ambiente;

    @GetMapping("/hello")
    public String helloWorld() {
        return applicationName + " " + ambiente;
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
