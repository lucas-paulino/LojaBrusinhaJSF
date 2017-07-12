package objetos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VendaProduto implements Serializable{
    @Id
    @ManyToOne
    private Venda venda;
    
    @Id
    @ManyToOne
    private Produto produto;
    
    @Column (nullable=false)
    private String quantidade;
    
    @Column (nullable=false)
    private String tamanho;

    public Venda getVenda() { return venda; }
    public void setVenda(Venda venda) { this.venda = venda; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public String getQuantidade() { return quantidade; }
    public void setQuantidade(String quantidade) { this.quantidade = quantidade; }
    
    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }
}
