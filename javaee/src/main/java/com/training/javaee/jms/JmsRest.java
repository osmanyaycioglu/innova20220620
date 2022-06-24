package com.training.javaee.jms;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/jms")
public class JmsRest {

    @Resource(lookup = "java:/jms/MyJMSQueue")
    private Queue      queue;

    @Resource(lookup = "java:/jms/MyJMSTopic")
    private Topic      topic;

    @Inject
    private JMSContext jmsContext;

    @Path("/queue")
    @GET
    public String sendToQueue(@QueryParam("msg") final String msg) {
        this.jmsContext.createProducer()
                       .send(this.queue,
                             msg);
        return "OK";
    }

    @Path("/topic")
    @GET
    public String sendToTopic(@QueryParam("msg") final String msg) {
        this.jmsContext.createProducer()
                       .send(this.topic,
                             msg);
        return "OK";
    }


}
