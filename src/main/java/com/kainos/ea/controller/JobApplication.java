package com.kainos.ea.controller;

import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.service.EmployeeService;
import io.swagger.annotations.Api;
import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Api("API for Job Application app")
@Path("/api")
public class JobApplication {

    private static com.kainos.ea.service.EmployeeService employeeservice;

    public JobApplication (){
    employeeservice = new EmployeeService(new EmployeeDao());

    }

    @GET
    @Path("/viewjobroles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmployee () {
        try {
            return Response.ok(employeeservice.viewJobRoles()).build();
        } catch (Exception e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }
    @GET
    @Path("/print/{msg}")
    @Produces("text/html")
    public String getMsg(@PathParam("msg") String message){
        return "Hello from a RESTful Web service: " + message;
    }
}
