package br.com.agendamento.service;

import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.agendamento.dao.AgendamentoEmailDao;
import br.com.agendamento.entity.AgendamentoEmail;

@Stateful
public class AgendamentoEmailServico {

    private static final Logger LOGGER = Logger.getLogger(AgendamentoEmailServico.class.getName());

    @Inject
    private AgendamentoEmailDao emailDao;

    public List<AgendamentoEmail> lista() {
        return emailDao.lista();
    }

    public List<AgendamentoEmail> listarNaoAgendado() {
        return emailDao.listarNaoAgendado();
    }

    public void inserir(AgendamentoEmail agendamentoEmail) {
        agendamentoEmail.setAgendado(false);
        emailDao.inserir(agendamentoEmail);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void alterar(AgendamentoEmail agendamentoEmail) {
        if (agendamentoEmail.getEmail().equals("rafael@live.com")) {
            throw new RuntimeException();
        }
        agendamentoEmail.setAgendado(true);
        emailDao.alterar(agendamentoEmail);
    }

    public void enviar(AgendamentoEmail agendamentoEmail) {
        try {
            Thread.sleep(5000);
            LOGGER.info(
                    MessageFormat.format("O e-mail do(a) usuário(a) {0} foi enviado!", agendamentoEmail.getEmail()));
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }
    }

}
