import java.util.ArrayList;
import java.util.List;

public class Banco {

    public static final String NOME_DO_BANCO = "Ricos POO S/A";
    public static List<String> logTransacoes = new ArrayList<>();
    public static int[] saquesDiarios = new int[7];

    public static void registrarUmaTransacao(String descricao,
                                             int diaDaSemana){
        try{
            logTransacoes.add(descricao);
            saquesDiarios[diaDaSemana] += 1;
        }catch (Exception e){
            System.out.println("Falha na transação :"+descricao);
            logTransacoes.add(" Falha "+descricao);
        }
    }
    public static void imprimirDadosDoBanco(){
        System.out.println(" Transações registradas nos LOGs\n\n");
        System.out.println(" Banco: "+NOME_DO_BANCO);

        for (String log: logTransacoes){
            System.out.println("--> :"+log);
        }
        System.out.println("\n Total de saques por dia da semana");
        for (int i = 0; i < saquesDiarios.length; i++) {
            System.out.println("Dia da Semana: "+(i+1)+": "+saquesDiarios[i]);
        }
    }
}
