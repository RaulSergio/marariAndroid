package ucdb.br.sweccamobile.model;

/**
 * Created by drago on 01/10/2017.
 */

public class Perfil {
    private Integer id;
    private String descricao;

    public Perfil() {
    }

    public Perfil(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
