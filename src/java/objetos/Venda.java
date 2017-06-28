package objetos;

import java.text.SimpleDateFormat;

public class Venda {
    private int id;
    private Usuario comprador;
    private SimpleDateFormat data;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Usuario getComprador() { return comprador; }
    public void setComprador(Usuario comprador) { this.comprador = comprador; }

    public SimpleDateFormat getData() { return data; }
    public void setData(SimpleDateFormat data) { this.data = data; }   
}
