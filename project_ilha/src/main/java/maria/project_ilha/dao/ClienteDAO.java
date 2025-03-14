    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maria.project_ilha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import maria.project_ilha.dto.ClienteDTO;
import maria.project_ilha.factory.ConnectionFactory;

/**
 *
 * @author osbju
 */
public class ClienteDAO {
        private final Connection connection;

    public ClienteDAO() {
        connection = ConnectionFactory.getConnection();
    }

    // Operações do sistema (CRUD - Create (criar), Read (ler), Update (atualizar) e Delete (apagar)).
    public void adicionarCliente(ClienteDTO cliente) {
        try {
            String query = "INSERT INTO produtos (nome, idade, data_visita) VALUES (?, ?, ?)";

            try ( PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, cliente.getNome());
                pst.setDouble(2, cliente.getDatavisita());
                pst.setInt(3, cliente.getIdade());
                
                pst.executeUpdate();
                pst.close();

            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
    }

    public List<ClienteDTO> listarCliente() {
        List<ClienteDTO> clientes = new ArrayList();

        try {
            String query = "SELECT * FROM clientes";

            try (Statement st = connection.createStatement()) {

                try (ResultSet rs = st.executeQuery(query)) {
                    while (rs.next()) {
                        int id = rs.getInt("idclientes");
                        String nome = rs.getString("nome");
                        double data_visita = rs.getDouble("data_visita");
                        int idade = rs.getInt("idade");

                        ClienteDTO cliente = new ClienteDTO(id, nome, data_visita, idade);

                        clientes.add(cliente);

                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
        return clientes;
    }

    public void atualizarCliente(ClienteDTO cliente) {
        try {
            String query = "UPDATE clientes SET nome = ?, data_visita = ?, idade = ? WHERE idclientes = ?";
            try ( PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, cliente.getNome());
                ps.setDouble(2, cliente.getDatavisita());
                ps.setInt(3, cliente.getIdade());
                ps.setInt(4, cliente.getId());
               

                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
    }

    public void excluirCliente(int idCliente) {
        try {
            String query = "DELETE FROM clientes WHERE idclientess = ?";
            try ( PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, idCliente);
                pst.executeUpdate();
                pst.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
        }
    }
}
