package br.com.fiap.msclientes.service;

import br.com.fiap.msclientes.model.Cliente;
import br.com.fiap.msclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    public Cliente saveCliente(Cliente cliente) {
         return clienteRepository.save(cliente);
    }

    public ResponseEntity<?> findByIdCliente (Integer clienteId){
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);

        if (cliente != null){
            return ResponseEntity.ok(cliente);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }

    public Cliente updateCliente (Integer clienteId, Cliente alteraCliente){
        Cliente clienteExiste = clienteRepository.findById(clienteId).orElse(null);

        if(clienteExiste != null){
            clienteExiste.setNome(alteraCliente.getNome());
            clienteExiste.setCpf(alteraCliente.getCpf());
            clienteExiste.setCep(alteraCliente.getCep());
            clienteExiste.setRua(alteraCliente.getRua());
            clienteExiste.setBairro(alteraCliente.getBairro());
            clienteExiste.setNumCasa(alteraCliente.getNumCasa());
            clienteExiste.setTelefone(alteraCliente.getTelefone());

            return clienteRepository.save(clienteExiste);
        } else{
            throw new NoSuchElementException("Cliente não encontrado");
        }
    }

    public ResponseEntity<?> deleteCliente(Integer clienteId) {
        Cliente clienteExiste = clienteRepository.findById(clienteId).orElse(null);

        if (clienteExiste != null){
            clienteRepository.delete(clienteExiste);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Cliente excluido com sucesso!");
        } else{
            throw new NoSuchElementException("Cliente não encontrado");
        }
    }

}
