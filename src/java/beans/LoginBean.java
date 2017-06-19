package beans;

import objetos.Usuario;
import session.SessionContext;

public class LoginBean {
    private String login;    
    private String senha;    
    private String mensagemLogin;
    private Usuario user;
            
    public String logar(){                
        if( getLogin().equals("admin") && getSenha().equals("12345") ){
            System.out.println("\n Login: "+login+" - Senha: "+senha+"\n");
            user = new Usuario();            
            SessionContext sessao = SessionContext.getInstance();
            sessao.setAttribute("user", user);
            return "sucesso";            
        }else{ 
            setMensagemLogin("Login ou senha icorretos");
            return "erro"; 
        }
    }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getMensagemLogin() { return mensagemLogin; }
    public void setMensagemLogin(String mensagem) { this.mensagemLogin = mensagem; }

    public Usuario getUser() { return user; }
    public void setUser(Usuario user) { this.user = user; }
}
