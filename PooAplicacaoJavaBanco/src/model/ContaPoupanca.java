package model;

// Aplicação do Pilar POO Herança
public class ContaPoupanca extends Conta {


    public ContaPoupanca(String numero) {
        super(numero);
    }

    @Override
    public void sacar(double valor) {

        if(valor <= saldo - 10){
            saldo -= valor;
        } else {
            System.out.println("❌ Saldo insuficiente na conta poupança");
        }

    }


}
