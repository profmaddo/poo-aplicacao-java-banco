package database;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class ContaDAO {

    public static void salvar(Conta conta, String tipo) {
        String sql = "INSERT INTO conta (numero, tipo, saldo) VALUES (?, ?, ?);";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, conta.getNumero());
            stmt.setString(2, tipo);
            stmt.setDouble(3, conta.getSaldo());
            stmt.executeUpdate();
            System.out.println("✅ model.Conta salva no banco.");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao salvar conta: " + e.getMessage());
        }
    }

    public static List<Conta> listarContas() {
        String sql = "SELECT * FROM conta;";
        List<Conta> lista = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String numero = rs.getString("numero");
                String tipo = rs.getString("tipo");
                double saldo = rs.getDouble("saldo");

                Conta conta = tipo.equals("corrente") ?
                        new ContaCorrente(numero) : new ContaPoupanca(numero);
                conta.depositar(saldo); // simula estado atual
                lista.add(conta);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao listar contas: " + e.getMessage());
        }

        return lista;
    }

    public static void atualizarSaldo(String numero, double novoSaldo) {
        String sql = "UPDATE conta SET saldo = ? WHERE numero = ?;";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoSaldo);
            stmt.setString(2, numero);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("❌ Erro ao atualizar saldo: " + e.getMessage());
        }
    }

    public static void deletarConta(String numero) {
        String sql = "DELETE FROM conta WHERE numero = ?;";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, numero);
            stmt.executeUpdate();
            System.out.println("🗑️ model.Conta removida.");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao deletar conta: " + e.getMessage());
        }
    }
}
