package beans;

import java.util.ArrayList;
import java.util.List;
import objetos.Categoria;
import objetos.Produto;

public class LojaBean {
    private List<Produto> produtos;
    
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
                p.setDescricao("Outra brusinha bem legal bem bacana para você");
                p.setImg("img/camisa2.jpg");
            }else{
                p.setId(i);
                p.setNome("Businha");
                p.setPreco("30,00"); 
                p.setCategoria(c);
                p.setDescricao("Uma brusinha bem legal bem bacana para você");
                p.setImg("img/camisa.jpg");  
            }
            produtos.add(p);
        }
        return "entrou";
    }
    
    public int numeroDeLinha(){ return produtos.size()/4; }

    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}
