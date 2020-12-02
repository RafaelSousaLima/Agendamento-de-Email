package br.com.agendamento.resource.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class ApplicationJAXRS extends Application {

//    @Override
//    public Map<String, Object> getProperties() {
//        Map<String, Object> properties = new HashMap<String, Object>();
//        properties.put("jersey.config.server.provider.packages", "br.com.agendamento.resource.*");
//        return properties;
//    }

}
