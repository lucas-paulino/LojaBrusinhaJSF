package objetos;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Venda {
    @Id
    @GeneratedValue
    private int id;
    private Date data;
    
    @ManyToOne
    private Usuario comprador;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Usuario getComprador() { return comprador; }
    public void setComprador(Usuario comprador) { this.comprador = comprador; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }   
}
