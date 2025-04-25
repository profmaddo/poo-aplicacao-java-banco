// Aplicação do Pilar POO Polimorfismo
public class CaixaEletronico {
    public void executarTransacao(Conta conta, String operacao, double valor){
        try{
            switch (operacao){
                case "depositar":
                    conta.depositar(valor);
                    System.out.println("💵 Depósito de USD "+ valor + " concluído.");
                    break;
                case "sacar":
                    conta.sacar(valor);
                    System.out.println("💵 Saque de USD "+ valor + " concluído.");
                    break;
                default:
                    System.out.println(" Opção inválida.");
            }
        }catch (Exception e){
            System.out.println(" Falha da transação "+e.getMessage());
        }
    }
}
