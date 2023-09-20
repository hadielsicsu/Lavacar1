/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lavacar;

/**
 *
 * @author hadiel
 */
public class PlanoAssinatura {
    private String nome;
    private int numeroLavagensPorMes;
    private String formaPagamento;

    public PlanoAssinatura(String nome, int numeroLavagensPorMes, String formaPagamento) {
        this.nome = nome;
        this.numeroLavagensPorMes = numeroLavagensPorMes;
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "PlanoAssinatura{" +
                "nome='" + getNome() + '\'' +
                ", numeroLavagensPorMes=" + getNumeroLavagensPorMes() +
                ", formaPagamento='" + getFormaPagamento() + '\'' +
                '}';
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the numeroLavagensPorMes
     */
    public int getNumeroLavagensPorMes() {
        return numeroLavagensPorMes;
    }

    /**
     * @param numeroLavagensPorMes the numeroLavagensPorMes to set
     */
    public void setNumeroLavagensPorMes(int numeroLavagensPorMes) {
        this.numeroLavagensPorMes = numeroLavagensPorMes;
    }

    /**
     * @return the formaPagamento
     */
    public String getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
