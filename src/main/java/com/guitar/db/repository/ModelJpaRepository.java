package com.guitar.db.repository;

import com.guitar.db.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ModelJpaRepository extends JpaRepository<Model, Long> {

    List<Model> findByPriceLessThanEqualAndPriceGreaterThanEqual(
            BigDecimal less, BigDecimal greater
    );

    List<Model> findByModelTypeNameIn(List<String> types);

}
