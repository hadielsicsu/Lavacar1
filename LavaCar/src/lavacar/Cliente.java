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
public class Cliente {
    private String nome;
    private String sobrenome;
    private String sexo;
    private String telefone;
    private String dataNascimento;
    private String endereco;
    private PlanoAssinatura planoAssinatura; 
    private List<String> agendamentoLavagens = new ArrayList<>();
    private Veiculo veiculo;
    // Construtor
    public Cliente(String nome, String sobrenome, String sexo, String telefone, String dataNascimento, String endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    // Métodos getters e setters para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Métodos getters e setters para sobrenome
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    // Métodos getters e setters para sexo
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    // Métodos getters e setters para telefone
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Métodos getters e setters para data de nascimento
    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Métodos getters e setters para endereço
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", sexo=" + sexo +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", endereco='" + endereco + '\'' +
                ", planoAssinatura=" + planoAssinatura +
                '}';
    }

    /**
     * @return the planoAssinatura
     */
    public PlanoAssinatura getPlanoAssinatura() {
        return planoAssinatura;
    }

    /**
     * @param planoAssinatura the planoAssinatura to set
     */
    public void setPlanoAssinatura(PlanoAssinatura planoAssinatura) {
        this.planoAssinatura = planoAssinatura;
    }

    /**
     * @return the veiculo
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    // Método para obter a lista de agendamento de lavagens
    public List<String> getAgendamentoLavagens() {
        return agendamentoLavagens;
    }

    // Método para agendar uma lavagem
    public void agendarLavagem(String dataHorario) {
        // Verifique se o cliente tem um plano válido para agendamento
        if (podeAgendarLavagem()) {
            // Adicione a data e horário do agendamento à lista
            agendamentoLavagens.add(dataHorario);
        }
    }

    // Método para verificar se o cliente pode agendar uma lavagem
    public boolean podeAgendarLavagem() {
        if (planoAssinatura != null) {
            // Verifique se o cliente atingiu o limite de lavagens do plano
            int numeroLavagensAgendadas = agendamentoLavagens.size();
            int numeroLavagensPlano = planoAssinatura.getNumeroLavagensPorMes();
            return numeroLavagensAgendadas < numeroLavagensPlano;
        }
        return false; // O cliente não possui um plano válido
    }

    // Método para obter a lista de planos de assinatura do cliente
    public List<PlanoAssinatura> getPlanosAssinatura() {
        List<PlanoAssinatura> planos = new ArrayList<>();
        if (planoAssinatura != null) {
            planos.add(planoAssinatura);
        }
        return planos;
    }
}