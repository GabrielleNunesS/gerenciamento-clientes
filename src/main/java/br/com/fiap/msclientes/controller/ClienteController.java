package br.com.fiap.msclientes.controller;

import br.com.fiap.msclientes.model.Cliente;
import br.com.fiap.msclientes.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllCliente() {
        return clienteService.getAllCliente();
    }

    @GetMapping ("/{clienteId}")
    public ResponseEntity<?> findByIdCliente (@PathVariable Integer clienteId){
        return clienteService.findByIdCliente(clienteId);
    }
    @PostMapping
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return clienteService.saveCliente(cliente);
    }

    @PutMapping("/{clienteId}")
    public Cliente updateCliente(@PathVariable Integer clienteId, @RequestBody Cliente alteraCliente){
        return clienteService.updateCliente(clienteId, alteraCliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<?> deleteCliente(@PathVariable Integer clienteId){
       return clienteService.deleteCliente(clienteId);
    }
}
