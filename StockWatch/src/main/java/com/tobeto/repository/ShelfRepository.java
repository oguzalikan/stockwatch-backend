package com.tobeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tobeto.entity.Shelf;

public interface ShelfRepository extends JpaRepository<Shelf, Integer> {
	@Query("SELECT s FROM Shelf s WHERE s.product.id = :productId and s.count < s.capacity")
	Optional<Shelf> findByProductIdNotFull(int productId);

	List<Shelf> findAllByCount(int count);

	List<Shelf> findAllByProductIdAndCountGreaterThan(int id, int count);

	@Query("SELECT sum(s.count) FROM Shelf s WHERE s.product.id = :productId")
	Integer getProductCount(int productId);
}
