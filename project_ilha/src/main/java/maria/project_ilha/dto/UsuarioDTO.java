/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maria.project_ilha.dto;

/**
 *
 * @author osbju
 */
public class UsuarioDTO {
    private int id;
    private String Usuario, Senha;
    
    public UsuarioDTO(String Usuario, String Senha) {
        this.id = id;
        this.Usuario = Usuario;
        this.Senha = Senha;
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        this.Usuario = usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        this.Senha = senha;
    }

   
}
