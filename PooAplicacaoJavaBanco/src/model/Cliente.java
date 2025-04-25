package model;

// Aplicação do Pilar POO Encapsulamento
public class Cliente {

    private String nome;
    private Conta conta;

    public Cliente(String nome, Conta conta){
        this.nome = nome;
        this.conta = conta;
    }

    public void comprovanteSaldoContaCliente(){
        System.out.println("model.Cliente: "+nome);
        System.out.println("model.Conta: "+ conta.getNumero());
        System.out.println("Saldo: "+ conta.getSaldo());
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
