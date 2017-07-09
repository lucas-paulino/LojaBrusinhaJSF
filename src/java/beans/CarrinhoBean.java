package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.component.html.HtmlSelectOneMenu;
import objetos.ItemCarrinho;
import objetos.Produto;
import objetos.Usuario;
import session.SessionContext;

public class CarrinhoBean {
    private List<ItemCarrinho> itens;
    private HtmlSelectOneMenu tamanho;
    private String quantidade;
    private Produto produto;
    private double total;
    private String mensagemCarrinho;
    
    public String adicionarAoCarrinho(Produto p){               
        produto = new Produto();
        this.produto = p;
        
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
        
        calcTotal(itens);
        
        return "addcarrinho";
    }
    
    public String removerdoCarrinho(ItemCarrinho i){
        itens = (List<ItemCarrinho>) SessionContext.getInstance().getAttribute("itens");
        itens.remove(i);
        SessionContext.getInstance().setAttribute("itens", itens);
        calcTotal(itens);
        return "removido";
    }
    
    public void calcTotal(List<ItemCarrinho> is){
        for( ItemCarrinho i : is ){
            total += i.valorSubTotal();            
        }
        SessionContext.getInstance().setAttribute("totalCarrinho", total);
    }

    public String finalizarVenda(){
        if(SessionContext.getInstance().getAttribute("itens") != null){            
            Usuario u = new Usuario();
            u = (Usuario) SessionContext.getInstance().getAttribute("user");
            
            if(u == null){
                System.out.println("Sem User");
                setMensagemCarrinho("Faça login para finalizar a venda");
                return "semUser";
            }else{         
                if(u.isAdmin()){
                    System.out.println("Admin Não Faz Compra");
                    setMensagemCarrinho("Administrador não pode faz compra");
                    return "AdminNaoCompra";
                }else{
                    System.out.println("Deu Certo");
                    return "deuCerto";
                }                
            }                
        }else{
            System.out.println("Carrinho Vazio");
            return "vazio";
        }
    }
            
    public List<ItemCarrinho> getItens() { return itens; }
    public void setItens(List<ItemCarrinho> itens) { this.itens = itens; }

    public HtmlSelectOneMenu getTamanho() { return tamanho; }
    public void setTamanho(HtmlSelectOneMenu tamanho) { this.tamanho = tamanho; }

    public String getQuantidade() { return quantidade; }
    public void setQuantidade(String quantidade) { this.quantidade = quantidade; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public String getMensagemCarrinho() { return mensagemCarrinho; }
    public void setMensagemCarrinho(String mensagemCarrinho) { this.mensagemCarrinho = mensagemCarrinho; }
}
