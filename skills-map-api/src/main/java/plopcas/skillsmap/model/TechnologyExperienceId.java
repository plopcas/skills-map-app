package plopcas.skillsmap.model;

import java.io.Serializable;

import javax.persistence.Column;

public class TechnologyExperienceId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "technology_id")
    private Long technologyId;
    private Integer year;

    public TechnologyExperienceId() {
	super();
    }

    public TechnologyExperienceId(Long personId, Long technologyId, Integer year) {
	super();
	this.personId = personId;
	this.technologyId = technologyId;
	this.year = year;
    }

    public Long getPersonId() {
	return personId;
    }

    public void setPersonId(Long personId) {
	this.personId = personId;
    }

    public Long getTechnologyId() {
	return technologyId;
    }

    public void setTechnologyId(Long technologyId) {
	this.technologyId = technologyId;
    }

    public Integer getYear() {
	return year;
    }

    public void setYear(Integer year) {
	this.year = year;
    }
}
