package objetos;

public class ItemCarrinho {
    private Produto produto;
    private String tamanho;
    private int quantidade;
    
    public ItemCarrinho(Produto p , String t, int q){
        this.produto = p;
        this.tamanho = t;
        this.quantidade = q;
    }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }    
}
