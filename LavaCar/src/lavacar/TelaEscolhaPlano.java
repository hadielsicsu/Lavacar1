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


public class TelaEscolhaPlano extends JFrame {

    private JComboBox<PlanoAssinatura> planosComboBox;
    private JComboBox<String> formaPagamentoComboBox;
    private JButton cadastrarButton;

    public TelaEscolhaPlano(Cliente cliente, Armazenamento armazenamento) {
        setTitle("Escolha do Plano de Assinatura");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ComboBox para seleção de plano
        panel.add(new JLabel("Selecione um Plano:"));
        planosComboBox = new JComboBox<>();
        // Adicione os planos disponíveis (você pode personalizar isso)
        planosComboBox.addItem(new PlanoAssinatura("Plano Básico", 4, "Cartão de Crédito"));
        planosComboBox.addItem(new PlanoAssinatura("Plano Premium", 8, "PIX"));
        planosComboBox.addItem(new PlanoAssinatura("Plano VIP", 12, "Boleto"));
        panel.add(planosComboBox);

        // ComboBox para seleção da forma de pagamento
        panel.add(new JLabel("Forma de Pagamento:"));
        formaPagamentoComboBox = new JComboBox<>();
        formaPagamentoComboBox.addItem("Cartão de Crédito");
        formaPagamentoComboBox.addItem("PIX");
        formaPagamentoComboBox.addItem("Boleto");
        panel.add(formaPagamentoComboBox);

        // Botão para cadastrar o plano
        cadastrarButton = new JButton("Cadastrar Plano");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlanoAssinatura planoSelecionado = (PlanoAssinatura) planosComboBox.getSelectedItem();
                String formaPagamento = (String) formaPagamentoComboBox.getSelectedItem();
                planoSelecionado.setFormaPagamento(formaPagamento);
                // Associe o plano selecionado ao cliente
                cliente.setPlanoAssinatura(planoSelecionado);                

                // Atualize o cliente no armazenamento (se necessário)
                armazenamento.atualizarCliente(cliente);

                // Exiba uma mensagem de sucesso ou redirecione para a próxima tela
                JOptionPane.showMessageDialog(null, "Plano cadastrado com sucesso!");

                // Você pode redirecionar para outra tela aqui, como a tela principal
                dispose(); // Fecha a tela de escolha do plano
            }
        });
        panel.add(cadastrarButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }    
}

