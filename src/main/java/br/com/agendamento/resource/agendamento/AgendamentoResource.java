package br.com.agendamento.resource.agendamento;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.agendamento.entity.AgendamentoEmail;
import br.com.agendamento.service.AgendamentoEmailServico;

@Path("emails")
public class AgendamentoResource {

    @Inject
    private AgendamentoEmailServico agendamentoEmailServico;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response lista() {
        return Response.ok(agendamentoEmailServico.lista()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserir(AgendamentoEmail agendamentoEmail) {
        agendamentoEmailServico.inserir(agendamentoEmail);
        return Response.status(201).build();
    }

}
