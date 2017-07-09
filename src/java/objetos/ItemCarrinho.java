package objetos;

public class ItemCarrinho {
    private Produto produto;
    private String tamanho;
    private String quantidade;    
    
    public Double valorSubTotal(){
        double result = 0;
        String p = produto.getPreco().replace(",", ".");
        result = Integer.parseInt(quantidade) * Double.parseDouble(p);
        return result;
    }

    public String txtSubTotal(){        
        return Double.toString(valorSubTotal()).replace(".", ",");
    }
    
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }

    public String getQuantidade() { return quantidade; }
    public void setQuantidade(String quantidade) { this.quantidade = quantidade; }    
}
