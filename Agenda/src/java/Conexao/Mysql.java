package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class Mysql {

    public Connection conecta() {
        String host = "jdbc:mysql://localhost/agenda";
        String user = "root";
        String senha = "1q";

        Connection conexao = null;
        
        try {
            DriverManager.registerDriver(new Driver());
            conexao = DriverManager.getConnection(host, user, senha);
        } catch (SQLException ex) {
            System.out.println("Falha ao conectar ao banco de dados");
        }
        return conexao;

    }
}
