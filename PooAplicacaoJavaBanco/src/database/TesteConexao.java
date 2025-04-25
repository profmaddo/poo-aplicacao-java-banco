package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:banco_poo.db")) {
            System.out.println("✅ Conectado ao banco SQLite com sucesso!");
        } catch (Exception e) {
            System.out.println("❌ Erro ao conectar: " + e.getMessage());
        }
    }
}

