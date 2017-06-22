package beans;

import objetos.Telefone;
import objetos.Usuario;
import session.SessionContext;

public class LoginBean {
    private String login;    
    private String senha;    
    private String mensagemLogin;
            
    public String logar(){                
        if( getLogin().equals("admin") && getSenha().equals("12345") ){              
            Telefone tel = new Telefone();
            tel.setDdd("00");
            tel.setNumero("000000000");
            
            Usuario user = new Usuario();
            user.setId(0);
            user.setNome("adiministração");
            user.setCpf("000.000.000-00");
            user.setEmail("admin@email.com");
            user.setTelefone(tel);
            user.setLogin("login");
            user.setSenha("senha");
            user.setAdmin(true);
            
            SessionContext.getInstance().setAttribute("user", user);
            //SessionContext sessao = SessionContext.getInstance();
            //sessao.setAttribute("user", user);
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
}
