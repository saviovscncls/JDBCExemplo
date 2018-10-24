package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class JDBCExemplo {

    public static void main(String[] args) {
        String conexao = "valor";
        try {
            Connection mysql = DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "1q");
            
            String sql = "delete from contato where id = ?";
            
            PreparedStatement instrucao = mysql.prepareStatement(sql);
            
            instrucao.setInt(1, 4);
            
            instrucao.execute();
            
            System.out.println("Conectado!");
        } catch (SQLException e) {
            System.out.println("Erro");
            throw new RuntimeException(e.getMessage());
        }

    }
}
