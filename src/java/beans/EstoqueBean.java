package beans;

import java.util.List;
import javax.faces.component.html.HtmlInputText;
import objetos.Estoque;
import objetos.EstoqueDAO;
import session.SessionContext;
import util.GenericDAO;

public class EstoqueBean {
    private Estoque estoq;
    private HtmlInputText quantidade;
    
    public String atualizaEstoque(Estoque e){
        Estoque estoque = new Estoque();
        estoque.setId(e.getId());
        estoque.setProduto(e.getProduto());
        estoque.setQuantidade(Integer.parseInt(quantidade.getSubmittedValue().toString()));
        GenericDAO<Estoque> suport = new EstoqueDAO(Estoque.class);
        suport.update(estoque);
        return "estoqueAtualizado";
    }

    public Estoque getEstoq() { return estoq; }
    public void setEstoq(Estoque estoq) { this.estoq = estoq; }

    public HtmlInputText getQuantidade() { return quantidade; }
    public void setQuantidade(HtmlInputText quantidade) { this.quantidade = quantidade; }
}
