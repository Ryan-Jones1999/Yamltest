package com.kainos.ea.controller;

import com.kainos.ea.dao.UserDao;
import com.kainos.ea.model.User;
import com.kainos.ea.service.UserService;

import io.swagger.annotations.Api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("API for User Application app")
@Path("/api")
public class UserController {

   private static UserService userService;

   public UserController() {userService = new UserService(new UserDao());}

   @POST
   @Path("/register")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response createUser(User user) {
      try {
         return Response.ok(userService.registerUser(user)).build();
      } catch(Exception e) {
         return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
      }
   }
}
