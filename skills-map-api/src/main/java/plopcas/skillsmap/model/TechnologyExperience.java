package plopcas.skillsmap.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TechnologyExperienceId.class)
public class TechnologyExperience {

    @Id
    public Long personId;

    @Id
    public Long technologyId;

    @Id
    private Integer year;

    private Integer rating;

    public TechnologyExperience() {
	super();
    }

    public Integer getYear() {
	return year;
    }

    public void setYear(Integer year) {
	this.year = year;
    }

    public Integer getRating() {
	return rating;
    }

    public void setRating(Integer rating) {
	this.rating = rating;
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
}
