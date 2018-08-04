package plopcas.skillsmap.model;

import java.io.Serializable;

import javax.persistence.Column;

public class ProductExperienceId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "product_id")
    private Long productId;
    private Integer year;

    public ProductExperienceId() {
	super();
    }

    public ProductExperienceId(Long personId, Long productId, Integer year) {
	super();
	this.personId = personId;
	this.productId = productId;
	this.year = year;
    }

    public Long getPersonId() {
	return personId;
    }

    public void setPersonId(Long personId) {
	this.personId = personId;
    }

    public Long getProductId() {
	return productId;
    }

    public void setProductId(Long productId) {
	this.productId = productId;
    }

    public Integer getYear() {
	return year;
    }

    public void setYear(Integer year) {
	this.year = year;
    }
}