package com.kainos.ea.controller;

import com.kainos.ea.dao.JobDao;
import com.kainos.ea.exception.DatabaseException;
import com.kainos.ea.exception.NotAValidBandLevelException;
import com.kainos.ea.exception.RoleNotAddedException;
import com.kainos.ea.model.JobRole;
import com.kainos.ea.model.NewRoleRequest;
import com.kainos.ea.service.JobService;
import io.swagger.annotations.Api;
import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Api("API for Job Application app")
@Path("/api")
public class JobController {

    private static JobService jobService;

    public JobController(){
        jobService = new JobService(new JobDao());
    }

    @GET
    @Path("/specification/{jobid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobSpecification(@PathParam("jobid") int jobid) {
        try {
            return Response.ok(jobService.getSpecificationJob(jobid)).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/responsibility/{jobid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRes(@PathParam("jobid") int jobid) {
        try {
            return Response.ok(jobService.getResponsibilityJob(jobid)).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/viewjobroles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewJobRoles () {
        try {
            return Response.ok(jobService.viewJobRoles()).build();
        } catch (DatabaseException | SQLException e) {
            e.printStackTrace();
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }
    @GET
    @Path("/viewjobcapabilities")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewJobCapabilities () {
        try {
            return Response.ok(jobService.viewJobCapabilities()).build();
        } catch (DatabaseException | SQLException e) {
            e.printStackTrace();
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }
    @GET
    @Path("/viewcompetency/{bandlevelID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewCompentency (@PathParam("bandlevelID") int bandID) {
        try {
            return Response.ok(jobService.competency(bandID)).build();
        } catch (DatabaseException | SQLException |  NotAValidBandLevelException e) {
            e.printStackTrace();
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }

    @GET
    @Path("/populatefamilylist")
    @Produces(MediaType.APPLICATION_JSON)
    public Response populateFamilyLists () {
        try {
             return Response.ok(jobService.populateFamilyLists()).build();
        } catch (DatabaseException | SQLException e) {
            e.printStackTrace();
             return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();

        }
    }

    @GET
    @Path("/populatecapabiltylist")
    @Produces(MediaType.APPLICATION_JSON)
    public Response populateCapabiltyList () {
        try {
            return Response.ok(jobService.populateCapabiltyLists()).build();
        } catch (DatabaseException | SQLException e) {
            e.printStackTrace();
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();

        }
    }

    @GET
    @Path("/populatebandlevelist")
    @Produces(MediaType.APPLICATION_JSON)
    public Response populateBandLevelList () {
        try {
            return Response.ok(jobService.populateBandLists()).build();
        } catch (DatabaseException | SQLException e) {
            e.printStackTrace();
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();

        }
    }

    @POST
    @Path("/addnewrole")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewRole (NewRoleRequest newrolerequest) {
        try {
            NewRoleRequest newrole = jobService.addNewRole(newrolerequest);
            return Response.status(HttpStatus.CREATED_201).entity(newrole).build();
        } catch (DatabaseException | SQLException | RoleNotAddedException e) {
            e.printStackTrace();
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();

        }
    }
}