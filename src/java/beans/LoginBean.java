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
            /*user.setId(0);
            user.setNome("Administrador");
            user.setCpf("00000000000");
            user.setEmail("admin@email.com");
            user.setTelefone("85", "988888888");
            user.setLogin("admin");
            user.setSenha("12345");
            user.setAdmin(true);
            */
            //SessionContext.getInstance().setAttribute("user",user);
            //SessionContext sessao = SessionContext.getInstance();
            //sessao.setAttribute("user", user);
            return "sucesso";            
        }else{ 
            mensagemLogin = "Login ou senha icorretos"; 
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
