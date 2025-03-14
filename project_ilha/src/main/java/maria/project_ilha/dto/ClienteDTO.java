/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maria.project_ilha.dto;

/**
 *
 * @author osbju
 */
public class ClienteDTO {
   private int id;
    private String nome;
    private double datavista;
    private int idade;
    private double datavisita;

    public ClienteDTO(int id, String nome, double datavisita, int idade) {
        this.id = id;
        this.nome = nome;
        this.datavisita = datavisita;
        this.idade = idade;
    }

    public ClienteDTO(String nome, double datavisita, int idade) {
        this.nome = nome;
        this.datavisita = datavisita;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDatavisita() {
        return datavisita;
    }

    public void setDatavisita(double datavisita) {
        this.datavisita = datavisita;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteDTO other = (ClienteDTO) obj;
        return this.id == other.id;
    }
}
