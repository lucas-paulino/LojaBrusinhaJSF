package beans;

import objetos.Usuario;
import session.SessionContext;

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
        mensagemCadastro = "Cadastro bem sucedido";
        return "sucesso";
    }
    
    public String atualizar(){
        
        Usuario u = new Usuario();
        u = (Usuario) SessionContext.getInstance().getAttribute("user");
                
        nome = u.getNome();
        cpf = u.getCpf();
        email = u.getEmail();
        login = u.getLogin();
        senha = u.getSenha();
        telefone = getTelefone();
        
        return "atualiza";
    }
    
    //Metodos Get e Set
        public String getTelefone() { return telefone; }
        public void setTelefone(String telefone) { this.telefone = telefone; }
    
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

        /*public String getTelefone() { return telefone.gettelefone(); }
        public void setTelefone(String ddd, String numero) { this.telefone.setDdd(ddd); this.telefone.setNumero(numero); }*/

        public boolean isAdmin() { return admin; }
        public void setAdmin(boolean admin) { this.admin = admin; }
        
        public String getMensagemCadastro() { return mensagemCadastro; }
        public void setMensagemCadastro(String mensagem) { this.mensagemCadastro = mensagem; }
}
