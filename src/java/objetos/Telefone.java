package objetos;
 
public class Telefone {
    private String ddd;
    private String numero;
    
    public Telefone(String d, String n){
        this.ddd = d;
        this.numero = n;
    } 
    
    public String gettelefone() { return ddd + numero; }
    
    public String getDdd() { return ddd; }
    public void setDdd(String ddd) { this.ddd = ddd; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }    
}
