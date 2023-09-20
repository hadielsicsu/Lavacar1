/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lavacar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author hadiel
 */
public class CadastroCliente extends JFrame {

    private JTextField nomeField, sobrenomeField, sexoField, telefoneField, dataNascimentoField, enderecoField;
    private JTextField marcaField, modeloField, anoField, corField, placaField;

    public CadastroCliente(Armazenamento armazenamento) {
        // Configuração da janela
        setTitle("Cadastro de Cliente e Veículo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(13, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margens

        // Estilo dos rótulos
        Font labelFont = new Font("Arial", Font.BOLD, 14);

        // Campos de informações pessoais
        panel.add(new JLabel("Nome:")).setFont(labelFont);
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("Sobrenome:")).setFont(labelFont);
        sobrenomeField = new JTextField();
        panel.add(sobrenomeField);

        panel.add(new JLabel("Sexo:")).setFont(labelFont);
        sexoField = new JTextField();
        panel.add(sexoField);

        panel.add(new JLabel("Telefone:")).setFont(labelFont);
        telefoneField = new JTextField();
        panel.add(telefoneField);

        panel.add(new JLabel("Data de Nascimento:")).setFont(labelFont);
        dataNascimentoField = new JTextField();
        panel.add(dataNascimentoField);

        panel.add(new JLabel("Endereço:")).setFont(labelFont);
        enderecoField = new JTextField();
        panel.add(enderecoField);

        // Campos de informações do veículo
        panel.add(new JLabel("Marca:")).setFont(labelFont);
        marcaField = new JTextField();
        panel.add(marcaField);

        panel.add(new JLabel("Modelo:")).setFont(labelFont);
        modeloField = new JTextField();
        panel.add(modeloField);

        panel.add(new JLabel("Ano:")).setFont(labelFont);
        anoField = new JTextField();
        panel.add(anoField);

        panel.add(new JLabel("Cor:")).setFont(labelFont);
        corField = new JTextField();
        panel.add(corField);

        panel.add(new JLabel("Placa:")).setFont(labelFont);
        placaField = new JTextField();
        panel.add(placaField);

        // Botão de cadastro
        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(labelFont);
        cadastrarButton.setBackground(Color.GREEN);
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String sobrenome = sobrenomeField.getText();
                String sexo = sexoField.getText();
                String telefone = telefoneField.getText();
                String dataNascimento = dataNascimentoField.getText();
                String endereco = enderecoField.getText();

                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                int ano = Integer.parseInt(anoField.getText()); // Converter para inteiro
                String cor = corField.getText();
                String placa = placaField.getText();

                // Crie um objeto Cliente com as informações do usuário
                Cliente cliente = new Cliente(nome, sobrenome, sexo, telefone, dataNascimento, endereco);

                // Crie um objeto Veiculo com as informações do veículo
                Veiculo veiculo = new Veiculo(marca, modelo, ano, cor, placa);

                // Adicione o veículo ao cliente
                cliente.setVeiculo(veiculo);

                // Adicione o cliente ao Armazenamento
                armazenamento.adicionarCliente(cliente);

                // Exiba uma mensagem de sucesso ou redirecione para a próxima tela
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                dispose(); // Fecha a tela de login
                new TelaPrincipal(cliente, armazenamento);
                // Você pode redirecionar para outra tela aqui
            }
        });

        panel.add(cadastrarButton);

        // Adicione o painel à janela
        add(panel);

        // Exibir a janela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new CadastroCliente();
//            }
//        });
//    }
}
