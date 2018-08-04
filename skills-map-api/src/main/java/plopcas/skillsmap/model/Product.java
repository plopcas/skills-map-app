package plopcas.skillsmap.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1)
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty
    private String name;

    public Product() {
	super();
    }

    public Product(Long id) {
	super();
	this.id = id;
    }

    public Product(String name) {
	super();
	this.name = name;
    }

    public Product(Long id, String name) {
	super();
	this.id = id;
	this.name = name;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
