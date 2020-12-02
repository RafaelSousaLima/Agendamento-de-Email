package br.com.agendamento.service.job;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import br.com.agendamento.entity.AgendamentoEmail;
import br.com.agendamento.service.AgendamentoEmailServico;

@Singleton
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AgendamentoEmailJob {

    @Inject
    private AgendamentoEmailServico servico;

    @Inject
    @JMSConnectionFactory("java:/jboss/DefaultJMSConnectionFactory")
    private JMSContext context;

    @Resource(mappedName = "java:/jms/queue/EmailQueue")
    private Queue queue;

    @Schedule(hour = "*", minute = "*", second = "*/10")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void enviarEmail() {
        List<AgendamentoEmail> listarNaoAgendado = servico.listarNaoAgendado();
        listarNaoAgendado.forEach(email -> {
            context.createProducer().send(queue, email);
            servico.alterar(email);
        });
    }

}
