package de.hawai.mps.transport;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("transport/{remoteId}")
public class TransportTaskResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TransportTaskBean get(@PathParam("remoteId") long id) {
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();

        Object o = session.load(TransportTaskBean.class, id);
        if(o instanceof  TransportTaskBean) {
            return (TransportTaskBean)o;
        }

        transaction.commit();

        return null;
    }

}
