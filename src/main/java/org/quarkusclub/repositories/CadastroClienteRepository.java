package org.quarkusclub.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.quarkusclub.models.ClienteEntity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CadastroClienteRepository {

    // Nossa persistência em memória
    private List<ClienteEntity> clientes = new ArrayList<>();

    public ClienteEntity createCliente(ClienteEntity cliente) {
        cliente.setId(UUID.randomUUID());
        clientes.add(cliente);
        return cliente;
    }

    public ClienteEntity updateCliente(ClienteEntity cliente) {
        clientes.stream().findFirst().filter(c -> c.getId().equals(cliente.getId())).ifPresent(c -> {
            c.setNome(cliente.getNome());
            c.setCpf(cliente.getCpf());
            c.setEndereco(cliente.getEndereco());
            c.setCidade(cliente.getCidade());
            c.setEstado(cliente.getEstado());
            c.setEmail(cliente.getEmail());
            c.setTelefone(cliente.getTelefone());
            c.setNomePlano(cliente.getNomePlano());
            c.setIndicacao(cliente.getIndicacao());
        });
        return cliente;
    }

    public List<ClienteEntity> consultaClientes() {
        return clientes;
    }

    public ClienteEntity consultaCliente(UUID idcliente) {
        return clientes.stream().filter(c -> c.getId().equals(idcliente)).findFirst().orElse(null);
    }
}
