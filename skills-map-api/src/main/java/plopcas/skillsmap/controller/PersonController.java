package plopcas.skillsmap.controller;

import io.swagger.annotations.Api;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import plopcas.skillsmap.model.Person;
import plopcas.skillsmap.service.PersonService;

@Controller
@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @Context
    private UriInfo uriInfo;

    @GET
    public List<Person> findAll() {
	return this.personService.findAll();
    }

    @GET
    @Path("{id}")
    public Person findOne(@PathParam("id") Long id) {
	return this.personService.findOne(id);
    }

    @POST
    public Response save(Person person) {
	person = this.personService.save(person);

	URI location = uriInfo.getAbsolutePathBuilder().path("{id}").resolveTemplate("id", person.getId()).build();

	return Response.created(location).build();
    }
}
