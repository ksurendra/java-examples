package com.tf.core.servlet;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import com.google.gson.JsonObject;
import org.bson.types.ObjectId;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.apache.commons.io.IOUtils;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


/**
 * JAX-RS resource class that provides operations for authentication.
 *
 * @author Suren Konathala
 */
@Path("/files")
@RequestScoped
public class FileUploadServlet {
	
    @POST
	@Path("/imageupload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
    public Response uploadImage(@FormDataParam("file") InputStream uploadedInputStream,
									@FormDataParam("file") FormDataContentDisposition fileDetails) {

		System.out.println("\n\n..CandidateServlet.uploadImage()");
		System.out.println(fileDetails.getFileName());

		return Response.ok("File uploaded = " + fileDetails.getFileName()).build();
	}

}

