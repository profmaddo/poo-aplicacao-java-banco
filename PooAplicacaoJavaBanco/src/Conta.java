// Aplicação do Pilar POO Abstração
public abstract class Conta {

    protected String numero;
    protected double saldo;

    public Conta(String numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public void depositar(double valor){
        // Regra de Negócio
        if (valor > 0){
          //  saldo = saldo + valor;
            saldo += valor;
        }
    }

    public abstract void sacar(double valor);

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
