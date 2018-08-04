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
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import plopcas.skillsmap.model.ProductExperience;
import plopcas.skillsmap.model.ProductExperienceId;
import plopcas.skillsmap.service.ProductExperienceService;

@Controller
@Path("/productExperience")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/productExperience")
public class ProductExperienceController {
    @Autowired
    private ProductExperienceService productExperienceService;

    @Context
    private UriInfo uriInfo;

    @ApiOperation(value = "findAll", response = ProductExperience.class, responseContainer = "List")
    @GET
    public List<ProductExperience> findAll() {
	return this.productExperienceService.findAll();
    }

    @GET
    @Path("{personId}/{productId}/{year}")
    public ProductExperience findOne(@PathParam("personId") Long personId, @PathParam("productId") Long productId,
	    @PathParam("year") Integer year) {
	return this.productExperienceService.findOne(new ProductExperienceId(personId, productId, year));
    }

    @GET
    @Path("search")
    public Response findByParam(@QueryParam("personId") Long personId, @QueryParam("productId") Long productId,
	    @QueryParam("year") Integer year) {
	if (personId != null) {
	    return Response.ok(this.productExperienceService.findByPersonId(personId)).build();
	} else if (productId != null) {
	    return Response.ok(this.productExperienceService.findByProductId(productId)).build();
	} else if (year != null) {
	    return Response.ok(this.productExperienceService.findByYear(year)).build();
	} else {
	    return Response.status(Status.BAD_REQUEST).build();
	}
    }

    @POST
    public Response save(ProductExperience productExperience) {
	productExperience = this.productExperienceService.save(productExperience);

	URI location = uriInfo.getAbsolutePathBuilder().path("{personId}/{productId}/{year}")
		.resolveTemplate("personId", productExperience.getPersonId())
		.resolveTemplate("productId", productExperience.getProductId())
		.resolveTemplate("year", productExperience.getYear()).build();

	return Response.created(location).build();
    }
}
