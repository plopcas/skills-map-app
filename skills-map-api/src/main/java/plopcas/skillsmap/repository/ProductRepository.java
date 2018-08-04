package plopcas.skillsmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import plopcas.skillsmap.model.Product;

@Repository("ProductRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {
}
