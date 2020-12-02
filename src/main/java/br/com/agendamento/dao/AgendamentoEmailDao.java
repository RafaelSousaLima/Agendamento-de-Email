package br.com.agendamento.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.agendamento.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<AgendamentoEmail> lista() {
        return entityManager.createQuery("SELECT ae FROM AgendamentoEmail ae", AgendamentoEmail.class).getResultList();
    }

    public List<AgendamentoEmail> listarNaoAgendado() {
        return entityManager
                .createQuery("SELECT ae FROM AgendamentoEmail ae where ae.agendado = false", AgendamentoEmail.class)
                .getResultList();
    }

    public void inserir(AgendamentoEmail agendamentoEmail) {
        entityManager.persist(agendamentoEmail);
    }

    public void alterar(AgendamentoEmail agendamentoEmail) {
        entityManager.merge(agendamentoEmail);
    }

}
