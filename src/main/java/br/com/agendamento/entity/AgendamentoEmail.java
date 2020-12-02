package br.com.agendamento.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AgendamentoEmail implements Serializable {

    private static final long serialVersionUID = -8505196419287288973L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String assunto;

    private String mensagem;

    private boolean agendado;

    public AgendamentoEmail() {
        // TODO Auto-generated constructor stub
    }

    protected AgendamentoEmail(Long id, String email, String assunto, String mensagem, boolean agendado) {
        super();
        this.id = id;
        this.email = email;
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.agendado = agendado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isAgendado() {
        return agendado;
    }

    public void setAgendado(boolean agendado) {
        this.agendado = agendado;
    }

}
