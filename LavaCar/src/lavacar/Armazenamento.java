/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lavacar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hadiel
 */
public class Armazenamento {
    private static List<Cliente> clientes = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public static List<Cliente> obterTodosClientes() {
        return clientes;
    }
    
    public void atualizarCliente(Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente clienteExistente = clientes.get(i);
            if (clienteExistente.getNome().equalsIgnoreCase(clienteAtualizado.getNome())) {
                // Substitua o cliente existente pelo cliente atualizado
                clientes.set(i, clienteAtualizado);
                return; // Saia do loop, pois o cliente foi atualizado
            }
        }
    }
}

