package beans;

import objetos.Usuario;
import objetos.UsuarioDAO;
import session.SessionContext;
import util.GenericDAO;

public class CadastroBean {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senha;
    private String telefone;
    private boolean admin;
    private String mensagemCadastro;
    
    public String cadastrar(){
        Usuario u = new Usuario();     
        u.setNome(nome);
        u.setCpf(cpf);
        u.setEmail(email);
        u.setLogin(login);
        u.setSenha(senha); 
        u.setTelefone(telefone);
        u.setAdmin(admin);        
        
        GenericDAO<Usuario> user = new UsuarioDAO(Usuario.class);
        user.save(u);
        
        mensagemCadastro = "Cadastro bem sucedida";
        return "sucesso";
    }
    
    public String atualiza(){
        Usuario u = new Usuario();     
        u.setId(id);
        u.setNome(nome);
        u.setCpf(cpf);
        u.setEmail(email);
        u.setLogin(login);
        u.setSenha(senha); 
        u.setTelefone(telefone);
        u.setAdmin(admin);
        
        GenericDAO<Usuario> user = new UsuarioDAO(Usuario.class);
        user.update(u);
        
        SessionContext.getInstance().setAttribute("user", u);
        mensagemCadastro = "Atualização bem sucedida";
        return "sucesso";
    }
    
    public String atualizar(){        
        Usuario u = (Usuario) SessionContext.getInstance().getAttribute("user");
        id = u.getId();
        nome = u.getNome();
        telefone = u.getTelefone();
        cpf = u.getCpf();
        email = u.getEmail();
        login = u.getLogin();
        senha = u.getSenha();        
        admin = u.isAdmin();
        return "atualiza";
    }
    
    public String ExcluirConta(Usuario u){
        GenericDAO<Usuario> user = new UsuarioDAO(Usuario.class);
        user.delete(u);        
        new LoginBean().sair();
        mensagemCadastro = "Conta excluida com sucesso";
        return "excluido";
    }
    
    //Metodos Get e Set        
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }

        public String getCpf() { return cpf; }
        public void setCpf(String cpf) { this.cpf = cpf; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getLogin() { return login; }
        public void setLogin(String login) { this.login = login; }

        public String getSenha() { return senha; }
        public void setSenha(String senha) { this.senha = senha; }

        public boolean isAdmin() { return admin; }
        public void setAdmin(boolean admin) { this.admin = admin; }

        public String getTelefone() { return telefone; }
        public void setTelefone(String telefone) { this.telefone = telefone; }
        
        public String getMensagemCadastro() { return mensagemCadastro; }
        public void setMensagemCadastro(String mensagem) { this.mensagemCadastro = mensagem; }
}
