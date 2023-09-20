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
public class TelaPrincipal extends JFrame {

    private Cliente cliente;
    private Armazenamento armazenamento;
    private JLabel nomeLabel;
    private JLabel planoLabel;
    private JButton cadastrarPlanoButton;
    private JButton visualizarPlanoButton;

    public TelaPrincipal(Cliente cliente, Armazenamento armazenamento) {
        this.cliente = cliente;
        this.armazenamento = armazenamento;

        setTitle("Tela Principal");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Nome do cliente logado
        nomeLabel = new JLabel("Bem-vindo, " + cliente.getNome() + "!");
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(nomeLabel);

        // Plano do cliente (se existir)
        PlanoAssinatura planoCliente = cliente.getPlanoAssinatura();
        if (planoCliente != null) {
            planoLabel = new JLabel("Seu Plano: " + planoCliente.getNome());
            panel.add(planoLabel);
        } else {
            // Botão para cadastrar plano
            cadastrarPlanoButton = new JButton("Cadastrar Plano");
            cadastrarPlanoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TelaCadastroPlanoPersonalizado tela = new TelaCadastroPlanoPersonalizado(cliente, armazenamento);
                }
            });
            panel.add(cadastrarPlanoButton);
        }

        // Botão para visualizar plano
        visualizarPlanoButton = new JButton("Visualizar Plano");
        visualizarPlanoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlanoAssinatura planoSelecionado = cliente.getPlanoAssinatura();

                if (planoSelecionado != null) {
                    // Exiba a tela de visualização de planos
                    new TelaVisualizarPlanos(cliente, armazenamento);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum plano selecionado.");
                }
            }
        });
        panel.add(visualizarPlanoButton);
        
        JButton suporteClienteButton = new JButton("Suporte ao Cliente");        
        suporteClienteButton.setBackground(Color.BLUE);
        suporteClienteButton.setForeground(Color.WHITE);
        suporteClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir a tela de Suporte ao Cliente
                new TelaSuporteCliente();
            }
        });
        panel.add(suporteClienteButton);


        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
