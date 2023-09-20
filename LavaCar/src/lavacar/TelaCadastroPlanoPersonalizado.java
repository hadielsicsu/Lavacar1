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
public class TelaCadastroPlanoPersonalizado extends JFrame {

    private Cliente cliente;
    private Armazenamento armazenamento;
    private JTextField nomePlanoField;
    private JTextField numeroLavagensField;
    private JComboBox<String> formaPagamentoComboBox;
    private JButton cadastrarButton;

    public TelaCadastroPlanoPersonalizado(Cliente cliente, Armazenamento armazenamento) {
        this.cliente = cliente;
        this.armazenamento = armazenamento;
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("Cadastro de Plano Personalizado");
        setSize(500, 250);        

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Campos para cadastro de plano personalizado        
        panel.add(new JLabel("Monte seu plano, nome do Plano:"));
        nomePlanoField = new JTextField();
        panel.add(nomePlanoField);

        panel.add(new JLabel("Número de Lavagens:"));
        numeroLavagensField = new JTextField();
        panel.add(numeroLavagensField);

        panel.add(new JLabel("Forma de Pagamento:"));
        formaPagamentoComboBox = new JComboBox<>();
        formaPagamentoComboBox.addItem("Cartão de Crédito");
        formaPagamentoComboBox.addItem("PIX");
        formaPagamentoComboBox.addItem("Boleto");
        panel.add(formaPagamentoComboBox);

        // Botão para cadastrar o plano personalizado
        cadastrarButton = new JButton("Cadastrar Plano Personalizado");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePlano = nomePlanoField.getText();
                int numeroLavagens = Integer.parseInt(numeroLavagensField.getText());
                String formaPagamento = (String) formaPagamentoComboBox.getSelectedItem();

                // Crie um objeto PlanoAssinatura com as informações fornecidas
                PlanoAssinatura novoPlano = new PlanoAssinatura(nomePlano, numeroLavagens, formaPagamento);

                // Associe o novo plano ao cliente
                cliente.setPlanoAssinatura(novoPlano);
                //cliente.setFormaPagamento(formaPagamento);

                // Atualize o cliente no armazenamento (se necessário)
                armazenamento.atualizarCliente(cliente);

                // Exiba uma mensagem de sucesso ou redirecione para a próxima tela
                JOptionPane.showMessageDialog(null, "Plano cadastrado com sucesso!");

                // Feche a tela de cadastro de plano personalizado
                dispose();
            }
        });
        panel.add(cadastrarButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
