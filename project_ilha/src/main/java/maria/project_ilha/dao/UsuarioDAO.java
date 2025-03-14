/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maria.project_ilha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import maria.project_ilha.dto.UsuarioDTO;
import maria.project_ilha.factory.ConnectionFactory;


/**
 *
 * @author osbju
 */
public class UsuarioDAO {
    private final Connection connection;

    public UsuarioDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public ResultSet autenticacaoUsuario(UsuarioDTO usuario) {

        try {
            String sql = "SELECT * FROM login10 WHERE idUsuario = ? Usuario = ? and Senha = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getSenha());
                           
            ResultSet rs = pst.executeQuery();
            return rs;
           
        } catch (SQLException e) {
            System.err.println("Erro ao realizar operação: " + e.getMessage());
            return null;
        }
    }
}
