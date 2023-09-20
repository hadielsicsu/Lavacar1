/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lavacar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author hadiel
 */

public class TelaVisualizarPlanos extends JFrame {

    private Cliente cliente;
    private Armazenamento armazenamento;
    private JComboBox<PlanoAssinatura> planosComboBox;
    private JButton agendarButton;
    private DefaultListModel<String> agendamentoListModel;
    private JList<String> agendamentoList;

    public TelaVisualizarPlanos(Cliente cliente, Armazenamento armazenamento) {
        this.cliente = cliente;
        this.armazenamento = armazenamento;
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("Visualizar Planos e Agendar Lavagens");
        setSize(600, 400);        

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // ComboBox para seleção de planos do cliente
        planosComboBox = new JComboBox<>();
        List<PlanoAssinatura> planosCliente = cliente.getPlanosAssinatura();
        for (PlanoAssinatura plano : planosCliente) {
            planosComboBox.addItem(plano);
        }
        panel.add(planosComboBox, BorderLayout.NORTH);

        // Lista para exibir agendamento de lavagens
        agendamentoListModel = new DefaultListModel<>();
        agendamentoList = new JList<>(agendamentoListModel);
        panel.add(new JScrollPane(agendamentoList), BorderLayout.CENTER);

        // Botão para agendar uma lavagem
        agendarButton = new JButton("Agendar Lavagem");
        agendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlanoAssinatura planoSelecionado = (PlanoAssinatura) planosComboBox.getSelectedItem();
                
                if (planoSelecionado != null && cliente.podeAgendarLavagem()) {                    
                    String dataHorarioAgendamento = JOptionPane.showInputDialog("Digite a data e horário do agendamento:");
                    if (dataHorarioAgendamento != null) {
                        cliente.agendarLavagem(cliente.getNome()+" - "+dataHorarioAgendamento);
                        atualizarListaAgendamento();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Você atingiu o limite de lavagens permitidas ou nenhum plano selecionado.");
                }
            }
        });
        panel.add(agendarButton, BorderLayout.SOUTH);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void atualizarListaAgendamento() {
        agendamentoListModel.clear();
        List<String> agendamento = cliente.getAgendamentoLavagens();
        for (String item : agendamento) {
            agendamentoListModel.addElement(item);
        }
    }
}
