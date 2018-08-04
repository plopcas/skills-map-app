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
import org.springframework.stereotype.Controller;

import plopcas.skillsmap.model.Product;
import plopcas.skillsmap.service.ProductService;

@Controller
@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Context
    private UriInfo uriInfo;

    @ApiOperation(value = "findAll", response = Product.class, responseContainer = "List")
    @GET
    public List<Product> findAll() {
	return this.productService.findAll();
    }

    @GET
    @Path("{id}")
    public Product findOne(@PathParam("id") Long id) {
	return this.productService.findOne(id);
    }

    @POST
    public Response save(Product product) {
	product = this.productService.save(product);

	URI location = uriInfo.getAbsolutePathBuilder().path("{id}").resolveTemplate("id", product.getId()).build();

	return Response.created(location).build();
    }
}
