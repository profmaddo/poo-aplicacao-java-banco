import model.Cliente;
import model.ContaCorrente;
import model.ContaPoupanca;

import java.util.Scanner;

/**
 * 4 Pilares da POO - Abstração, Herança, Encapsulamento e Poliforfismo
 * - Tratamento de erros
 * - Coleções tipadas, vetores, arrays
 *
 * Classe chamada model.Conta (abstrata)
 * Classe model.ContaCorrente (Herança)
 * Classe model.ContaPoupanca (Herança)
 * Classe model.Cliente (Encapsulamento) - modificadores de acesso getts e setts
 * Classe CaixaEletronico (Polimorfismo)
 * Classe Banco - Coleções, static, final, array, tratamento de erros (try catch)
 *
 */

public class AplicacaoBancoPOO {

    // AplicacaoBancoPOO banco = new AplicacaoBancoPOO();
    // AplicacaoBancoPOO.main();

    public static void main(String[] args) {

        System.out.println("Banco Digital Java POO");

        Scanner scanner = new Scanner(System.in);


        // Caixas eletrônicos liberados para uso
        CaixaEletronico caixaEletronico = new CaixaEletronico();

        // Criação das contas bancárias
        Cliente marco = new Cliente("Carlos", new ContaCorrente("001-2025-0"));
        Cliente maddo = new Cliente("Marco", new ContaPoupanca("002-2025-1"));

        // Opções (MENU - R)
        // 1 - model.Conta
        // 2 - Depósito
        // 3 - Saque
        // 4 - Ver dados da conta ou do banco
        // 5 - Sair
        // 6 - Instruções de uso

        int opcao;

        do {

            System.out.println("MENU PRINCIPAL DO BANCO\n\nSelecione uma opção\n");
            System.out.println("1 - Visualizar Saldo da model.Conta");
            System.out.println("2 - Efetuar um Depósito");
            System.out.println("3 - Sacar valor");
            System.out.println("4 - Ver detalhes do Banco");
            System.out.println("5 - Sair do Banco");
            System.out.println("6 - Instruções de uso");

            opcao = scanner.nextInt();

            Cliente cliente = marco;

            switch (opcao){

                case 1:
                    System.out.println("Opção 1 - Visualizar Saldo da model.Conta");
                    marco.comprovanteSaldoContaCliente();
                    break;
                case 2:
                    System.out.println("Digite o valor do depósito: ");
                    double valorDoDeposito = scanner.nextDouble();
                    caixaEletronico.executarTransacao(marco.getConta(),"depositar", valorDoDeposito);
                    Banco.registrarUmaTransacao("depósito",1);
                    break;
                case 3:
                    System.out.println("Digite o valor do saque: ");
                    double valorDoSaque = scanner.nextDouble();
                    caixaEletronico.executarTransacao(marco.getConta(),"sacar", valorDoSaque);
                    Banco.registrarUmaTransacao("saque",2);

                    break;
                case 4:
                    Banco.imprimirDadosDoBanco();
                    break;
                case 5:
                    System.out.println("Opção 5 - Sair do Banco");
                    System.out.println("Volte sempre!");
                    break;
                default:
                    System.out.println("Opção não disponível");

            }

        } while (opcao != 5);

        scanner.close();
    }

}
