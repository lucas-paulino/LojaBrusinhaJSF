package objetos;

public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senha;
    private Telefone telefone;
    private boolean admin;
    
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
        
        public Telefone getTelefone() { return telefone; }
        public void setTelefone(Telefone telefone) { this.telefone = telefone; }
        
        public boolean isAdmin() { return admin; }
        public void setAdmin(boolean admin) { this.admin = admin; }
}
