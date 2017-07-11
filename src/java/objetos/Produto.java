package objetos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
    @Id
    @GeneratedValue
    private int id;
    
    private String nome;
    @Column (nullable=false)
    private String preco;
    private String descricao;
    private String img;
    @ManyToOne
    private Categoria categoria;
    
    //Metodos Get e Set
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }

        public String getPreco() { return preco; }
        public void setPreco(String preco) { this.preco = preco; }

        public String getDescricao() { return descricao; }
        public void setDescricao(String descricao) { this.descricao = descricao; }

        public String getImg() { return img; }
        public void setImg(String img) { this.img = img; }

        public Categoria getCategoria() { return categoria; }
        public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}
