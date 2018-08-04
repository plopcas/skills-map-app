package plopcas.skillsmap.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "technology_id_seq")
    @SequenceGenerator(name = "technology_id_seq", sequenceName = "technology_id_seq", allocationSize = 1)
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty
    private String name;

    public Technology() {
	super();
    }

    public Technology(Long id) {
	this.id = id;
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
