package beans;

import java.util.List;
import objetos.Produto;

public class LojaBean {
    private List<Produto> produtos;
    
    public String vemLoja(){
        return "sucesso";
    }

    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}
