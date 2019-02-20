package com.jaqstack.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jaqstack.data.MongoExample;

@Path("/dbservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MongoServlet {

    @GET
    @Path("/product")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProduct() throws ServletException {
        MongoExample me = new MongoExample();

        //System.out.println("\n******* me.getProduct()="+ me.getProduct());

        return me.getProduct();
    }

}
