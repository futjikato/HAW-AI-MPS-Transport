package de.hawai.mps.transport;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("transports")
public class TransportTasksResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TransportTaskBean[] getList() {
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();

        Criteria crit = session.createCriteria(TransportTaskBean.class);
        List taskList = crit.list();

        TransportTaskBean[] ary = new TransportTaskBean[taskList.size()];
        int i = 0;
        for(Object o : taskList) {
            if(o instanceof TransportTaskBean) {
                ary[i++] = (TransportTaskBean) o;
            }
        }

        transaction.commit();

        return ary;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TransportTaskBean set(TransportTaskBean inBean) {
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(inBean);
        session.refresh(inBean);

        transaction.commit();

        return inBean;
    }

}
