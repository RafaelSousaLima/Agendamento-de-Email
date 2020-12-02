package br.com.agendamento.service.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import br.com.agendamento.entity.AgendamentoEmail;
import br.com.agendamento.service.AgendamentoEmailServico;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/EmailQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class AgendamentoEmailMDB implements MessageListener {

    @Inject
    private AgendamentoEmailServico agendamentoEmailServico;

    @Override
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        try {
            AgendamentoEmail agendamentoEmail = message.getBody(AgendamentoEmail.class);
            agendamentoEmailServico.enviar(agendamentoEmail);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

}
