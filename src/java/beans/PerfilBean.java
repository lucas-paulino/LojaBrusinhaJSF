package beans;

import objetos.Usuario;

public class PerfilBean {
    private Usuario user;
    
    public String criarPerfil(){
        return "sucesso";
    }

    public Usuario getUser() { return user; }
    public void setUser(Usuario user) { this.user = user; }
}
