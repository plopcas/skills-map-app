package plopcas.skillsmap.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
import org.springframework.stereotype.Component;

import plopcas.skillsmap.model.Technology;
import plopcas.skillsmap.service.TechnologyService;

@Component
@Path("/technology")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/technology")
public class TechnologyController {
    @Autowired
    private TechnologyService technologyService;

    @Context
    private UriInfo uriInfo;

    @GET
    @ApiOperation(value = "findAll", response = Technology.class, responseContainer = "List")
    public List<Technology> findAll() {
	return this.technologyService.findAll();
    }

    @GET
    @Path("{id}")
    public Technology findOne(@PathParam("id") Long id) {
	return this.technologyService.findOne(id);
    }

    @POST
    public Response save(Technology technology) {
	technology = this.technologyService.save(technology);

	URI location = uriInfo.getAbsolutePathBuilder().path("{id}").resolveTemplate("id", technology.getId()).build();

	return Response.created(location).build();
    }
}
