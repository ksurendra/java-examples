package com.jaqstack.servlet;

import javax.servlet.ServletException;
import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jaqstack.models.Cake;
import com.jaqstack.service.CakeService;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;

/**
 * JAX-RS resource class that provides operations.
 *
 * @author Suren Konathala
 */
@Path("/cake")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class TestServlet {
    @Inject
    CakeService cakeService;

    @POST
    @Path("/price")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public String calculate(Cake cake) {
        Double price = cakeService.calculatePrice(cake);

        return price.toString();
    }
}

