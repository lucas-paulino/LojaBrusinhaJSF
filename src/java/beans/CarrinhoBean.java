package beans;

import java.util.List;
import objetos.Produto;

public class CarrinhoBean {
    private List<Produto> itens;
    
    public void adicionarAoCarrinho(Produto p){
        this.itens.add(p);
    }

    public List<Produto> getItens() { return itens; }
    public void setItens(List<Produto> itens) { this.itens = itens; }    
}
