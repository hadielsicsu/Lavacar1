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

public class TelaSuporteCliente extends JFrame {

    public TelaSuporteCliente() {
        setTitle("Suporte ao Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Fechar apenas a janela de suporte

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Rótulo de boas-vindas ao suporte
        JLabel label = new JLabel("Bem-vindo ao Suporte ao Cliente");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label);

        // Área de texto para que o cliente possa inserir sua pergunta ou problema
        JTextArea mensagemTextArea = new JTextArea();
        mensagemTextArea.setWrapStyleWord(true);
        mensagemTextArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(mensagemTextArea);
        panel.add(scrollPane);

        // Botão para enviar a mensagem
        JButton enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // adicionar lógica para enviar a mensagem do cliente ao suporte
                JOptionPane.showMessageDialog(null, "Sua mensagem foi enviada com sucesso! Obrigado pelo contato.");
                dispose(); // Fecha a janela de suporte após o envio
            }
        });
        panel.add(enviarButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

