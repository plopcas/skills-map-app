package plopcas.skillsmap.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
    @SequenceGenerator(name = "person_id_seq", sequenceName = "person_id_seq", allocationSize = 1)
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty
    private String name;

    @Transient
    @OneToMany(mappedBy = "person")
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Set<TechnologyExperience> technologies = new HashSet<>();

    @Transient
    @OneToMany(mappedBy = "person")
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Set<ProductExperience> products = new HashSet<>();

    public Person() {
	super();
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

    public Set<TechnologyExperience> getTechnologies() {
	this.technologies.size();
	return technologies;
    }

    public void setTechnologies(Set<TechnologyExperience> technologies) {
	this.technologies = technologies;
    }

    public Set<ProductExperience> getProducts() {
	this.products.size();
	return products;
    }

    public void setProducts(Set<ProductExperience> products) {
	this.products = products;
    }

}
