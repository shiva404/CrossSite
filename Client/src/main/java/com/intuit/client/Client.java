package com.intuit.client;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import types.json.Something;

import javax.ws.rs.core.MediaType;

@Component
public class Client {

    private static final Logger logger = Logger.getLogger(Client.class);

    private String url;
    private WebResource resource;

    public Client(String url) {
        this.url = url;

    }

    public void init(){

        DefaultClientConfig cc = new DefaultClientConfig();
        // use POJO JSON conversion support
        cc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(cc);
        LoggingFilter lf = new LoggingFilter();
        client.addFilter(lf);
        resource = client.resource(url);

    }



    private void handleError(ClientResponse cr, int expected){
        if (cr.getStatus() != expected) {
           // logger.debug("oii rest response failed: {}", cr); // will log http status code
            if (cr.getType().isCompatible(MediaType.APPLICATION_JSON_TYPE)) {

            } else {

            }
        }
    }

    private <T> T getEntity(Class<T> clazz, ClientResponse cr){
        handleError(cr, 200);
        return cr.getEntity(clazz);
    }

    public Something getSomething() {
        ClientResponse cr = resource.path("/test/get").accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        return getEntity(Something.class, cr);
    }

    public void sendSomething(Something something){
        resource.path("/test/post").type(MediaType.APPLICATION_JSON_TYPE).entity(something).post();
    }

    public static void main(String[] args){
        Client client = new Client("http://localhost:8082/so");
        client.init();
        Something something = client.getSomething();
        System.out.println("recieved ---> " + something);

        client.sendSomething(something);

    }

}
