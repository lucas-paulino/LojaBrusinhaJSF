package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.component.html.HtmlSelectOneMenu;
import objetos.ItemCarrinho;
import objetos.Produto;
import session.SessionContext;

public class CarrinhoBean {
    private List<ItemCarrinho> itens;
    private HtmlSelectOneMenu tamanho;
    private String quantidade;
    private Produto produto;
    
    public String adicionarAoCarrinho(Produto p){               
        produto = new Produto();
        this.produto = p;
        
        double total = 0;
        
        ItemCarrinho item = new ItemCarrinho();
        item.setProduto(produto);
        item.setTamanho(tamanho.getValue().toString());
        item.setQuantidade(quantidade);  
        
        itens = (List<ItemCarrinho>) SessionContext.getInstance().getAttribute("itens");
        
        if(itens == null){
            itens = new ArrayList<ItemCarrinho>();
        }
        this.itens.add(item);
        SessionContext.getInstance().setAttribute("itens", itens);
        
        for( ItemCarrinho i : itens ){
            total += i.valorSubTotal();            
        }
        System.out.println("Total: "+total);
        System.out.println("------------------------------------------");
        SessionContext.getInstance().setAttribute("totalCarrinho", total);
        return "addcarrinho";
    }
    

    public List<ItemCarrinho> getItens() { return itens; }
    public void setItens(List<ItemCarrinho> itens) { this.itens = itens; }

    public HtmlSelectOneMenu getTamanho() { return tamanho; }
    public void setTamanho(HtmlSelectOneMenu tamanho) { this.tamanho = tamanho; }

    public String getQuantidade() { return quantidade; }
    public void setQuantidade(String quantidade) { this.quantidade = quantidade; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
}
