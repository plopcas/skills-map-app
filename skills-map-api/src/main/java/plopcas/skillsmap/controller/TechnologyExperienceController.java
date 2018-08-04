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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import plopcas.skillsmap.model.TechnologyExperience;
import plopcas.skillsmap.model.TechnologyExperienceId;
import plopcas.skillsmap.service.TechnologyExperienceService;

@Controller
@Path("/technologyExperience")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/technologyExperience")
public class TechnologyExperienceController {
    @Autowired
    private TechnologyExperienceService technologyExperienceService;

    @Context
    private UriInfo uriInfo;

    @ApiOperation(value = "findAll", response = TechnologyExperience.class, responseContainer = "List")
    @GET
    public List<TechnologyExperience> findAll() {
	return this.technologyExperienceService.findAll();
    }

    @GET
    @Path("{id}")
    public TechnologyExperience findOne(@PathParam("personId") Long personId,
	    @PathParam("technologyId") Long technologyId, @PathParam("year") Integer year) {
	return this.technologyExperienceService.findOne(new TechnologyExperienceId(personId, technologyId, year));
    }

    @GET
    @Path("search")
    public Response findByParam(@QueryParam("personId") Long personId, @QueryParam("technologyId") Long technologyId,
	    @QueryParam("year") Integer year) {
	if (personId != null) {
	    return Response.ok(this.technologyExperienceService.findByPersonId(personId)).build();
	} else if (technologyId != null) {
	    return Response.ok(this.technologyExperienceService.findByProductId(technologyId)).build();
	} else if (year != null) {
	    return Response.ok(this.technologyExperienceService.findByYear(year)).build();
	} else {
	    return Response.status(Status.BAD_REQUEST).build();
	}
    }

    @POST
    public Response save(TechnologyExperience technologyExperience) {
	technologyExperience = this.technologyExperienceService.save(technologyExperience);

	URI location = uriInfo.getAbsolutePathBuilder().path("{personId}/{technologyId}/{year}")
		.resolveTemplate("personId", technologyExperience.getPersonId())
		.resolveTemplate("technologyId", technologyExperience.getTechnologyId())
		.resolveTemplate("year", technologyExperience.getYear()).build();

	return Response.created(location).build();
    }
}
