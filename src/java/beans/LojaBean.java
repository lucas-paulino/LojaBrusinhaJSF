package beans;

import java.util.ArrayList;
import java.util.List;
import objetos.Categoria;
import objetos.Estoque;
import objetos.EstoqueDAO;
import objetos.Produto;
import objetos.ProdutoDAO;
import session.SessionContext;

public class LojaBean {
    private List<Produto> produtos;
    private Produto produto;
    
    public String vemLoja(){
        produtos = gerarProduto();
        SessionContext.getInstance().setAttribute("listaProdutos", produtos);
        return "entrou";
    }
    
    public String vemProduto(Produto p){
        setProduto(p);
        SessionContext.getInstance().setAttribute("produto", produto);
        return "acesso";
    }
    
    public List<Produto> gerarProduto(){
        List<Produto> produtosExe = new ArrayList<Produto>();
        List<Estoque> estoque = new EstoqueDAO(Estoque.class).temNoEstoque();
        for(Estoque e: estoque){
            produtosExe.add(e.getProduto());
        }
        return produtosExe;
    }
    
    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
    
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
}
