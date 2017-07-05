package beans;

import java.util.ArrayList;
import java.util.List;
import objetos.Categoria;
import objetos.Produto;
import session.SessionContext;

public class LojaBean {
    private List<Produto> produtos;
    private Produto produto;
    
    public String vemLoja(){
        produtos = new ArrayList<Produto>();        
        Categoria c = new Categoria();
        c.setId(0);
        c.setNome("Camisa");
        c.setDescricao("Camisa bem bacana");        
        for(int i=0;i<37;i++){            
            Produto p = new Produto();
            if(i%2 == 0){
                p.setId(i);
                p.setNome("OutraBusinha");
                p.setPreco("35,00"); 
                p.setCategoria(c);
                p.setDescricao("Brusinha na cor DarkSlateBlue, bem legal bem bacana para você");
                p.setImg("img/camisa2.jpg");
            }else{
                p.setId(i);
                p.setNome("Businha");
                p.setPreco("30,00"); 
                p.setCategoria(c);
                p.setDescricao("Brusinha na cor FireBrick, bem legal bem bacana para você");
                p.setImg("img/camisa.jpg");  
            }
            produtos.add(p);
        }
        SessionContext.getInstance().setAttribute("listaProdutos", produtos);
        return "entrou";
    }
    
    public String vemProduto(Produto p){
        setProduto(p);
        SessionContext.getInstance().setAttribute("produto", produto);
        return "acesso";
    }
    
    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
    
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
}
