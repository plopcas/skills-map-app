package plopcas.skillsmap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import plopcas.skillsmap.model.Product;
import plopcas.skillsmap.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product findOne(Long id) {
	return productRepository.findOne(id);
    }

    public List<Product> findAll() {
	return productRepository.findAll();
    }

    public Product save(Product Product) {
	return productRepository.save(Product);
    }

    public void delete(Long id) {
	productRepository.delete(id);
    }
}
