package beans;

import session.SessionContext;

public class LogoutBean {
    private String mensagem;

    public String processar() {
        SessionContext.getInstance().invalidateSession();
        mensagem = "Sua sessão foi encerrada";
        return "saiu";
    }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
}
