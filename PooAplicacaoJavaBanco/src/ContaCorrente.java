// Aplicação do Pilar POO Herança
public class ContaCorrente extends Conta{

    public ContaCorrente(String numero) {
        super(numero);
    }

    @Override
    public void sacar(double valor) {
        // Regra de Negócio específica para
        // efetuar um saque da conta corrente

        // consultar uma API para buscar o saldo atual
        // no banco de dados

        if(valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("❌ Saldo insuficiente na conta corrente");
        }


    }

}
