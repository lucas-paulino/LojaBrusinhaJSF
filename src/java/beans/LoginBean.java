package beans;

import java.util.List;
import objetos.Estoque;
import objetos.EstoqueDAO;
import objetos.Usuario;
import objetos.UsuarioDAO;
import session.SessionContext;

public class LoginBean {
    private String login;    
    private String senha;    
    private String mensagemLogin;
    
    public String logar(){
        Usuario user = new UsuarioDAO(Usuario.class).getByLoginSenha(getLogin(), getSenha());
        if( user != null ){              
            SessionContext.getInstance().setAttribute("user", user);
            
            if( user.isAdmin() ){
                List<Usuario> todosUser = (List<Usuario>) new UsuarioDAO(Usuario.class).getAll();
                SessionContext.getInstance().setAttribute("listaUser", todosUser);
                
                List<Estoque> estoque = (List<Estoque>) new EstoqueDAO(Estoque.class).getAll();
                SessionContext.getInstance().setAttribute("listaEstoque", estoque);
            }
            
            return "sucesso";            
        }else{ 
            setMensagemLogin("Login ou senha incorretos");
            return "erro"; 
        }
    }

    public String sair() {
        SessionContext.getInstance().invalidateSession();
        mensagemLogin = "Sua sessão foi encerrada";
        return "saiu";
    }
    
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getMensagemLogin() { return mensagemLogin; }
    public void setMensagemLogin(String mensagem) { this.mensagemLogin = mensagem; }
}
