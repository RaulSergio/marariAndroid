package ucdb.br.sweccamobile.model;

/**
 * Created by drago on 01/10/2017.
 */

public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Perfil perfil;

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String email, String senha, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }
}
