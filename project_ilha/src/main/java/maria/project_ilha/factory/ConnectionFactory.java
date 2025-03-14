/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maria.project_ilha.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author osbju
 */
public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/parqueaquatico02"; // Substitua pelo nome do seu banco
    private static final String USUARIO = "root"; // Substitua pelo seu usuário
    private static final String SENHA = "Roberta@086287";
    
    // Método que cria e retorna a conexão com o banco de dados
    public static Connection getConnection() {
        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Retorna a conexão com o banco de dados
            return DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao obter a conexão com o banco de dados: " + e.getMessage(), e);
        }
    }

    // Método para fechar a conexão com o banco de dados.
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados: " + e.getMessage(), e);
        }
    }
}
