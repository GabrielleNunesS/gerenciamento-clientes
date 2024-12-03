package br.com.fiap.msclientes.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table (name="tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cliente_id")
    private Integer id;

    @Column(name = "cliente_cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "cliente_nome", nullable = false)
    private String nome;

    @Column(name = "cliente_cep", nullable = false)
    private String cep;

    @Column (name = "cliente_rua", nullable = false)
    private String rua;

    @Column (name = "cliente_bairro", nullable = false)
    private String bairro;

    @Column (name= "cliente_numcasa", nullable = false)
    private int numCasa;

    @Column(name = "cliente_telefone", nullable = false)
    private String telefone;

}
