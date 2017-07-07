package beans;

import java.util.ArrayList;
import java.util.List;
import objetos.ItemCarrinho;
import objetos.Produto;
import session.SessionContext;

public class CarrinhoBean {
    private List<ItemCarrinho> itens;
    private String tamanho;
    private int quantidade;
    private Produto produto;
    
    
    public String adicionarAoCarrinho(Produto p){
        setProduto(p);
        ItemCarrinho item = new ItemCarrinho(produto,tamanho,quantidade);
        itens = (List<ItemCarrinho>) SessionContext.getInstance().getAttribute("carrinho");
        if(itens == null){
            itens = new ArrayList<ItemCarrinho>();
        }
        this.itens.add(item);
        SessionContext.getInstance().setAttribute("carrinho", itens);
        return "addcarrinho";
    }

    public List<ItemCarrinho> getItens() { return itens; }
    public void setItens(List<ItemCarrinho> itens) { this.itens = itens; }

    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }
    
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
}
