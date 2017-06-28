package objetos;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private String img;
    private Categoria categoria;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}
