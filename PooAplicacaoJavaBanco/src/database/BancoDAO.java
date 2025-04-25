package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDAO {

    public static void criarTabelas() {
        String sqlConta = """
                CREATE TABLE IF NOT EXISTS conta (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    numero TEXT NOT NULL UNIQUE,
                    tipo TEXT NOT NULL,
                    saldo REAL NOT NULL
                );
                """;

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlConta);
            System.out.println("✅ Tabelas criadas com sucesso.");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao criar tabelas: " + e.getMessage());
        }
    }

    public static void zerarBanco() {
        String sqlDrop = "DROP TABLE IF EXISTS conta;";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlDrop);
            System.out.println("🗑️ Tabelas excluídas.");
            criarTabelas();
        } catch (SQLException e) {
            System.out.println("❌ Erro ao resetar banco: " + e.getMessage());
        }
    }
}
