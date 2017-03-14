package com.guitar.db.repository;

import com.guitar.db.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {

    List<Manufacturer> findByFoundedDateBefore(Date date);

    Manufacturer findFirstByFoundedDateBefore(Date date);

    List<Manufacturer> findTop5ByFoundedDateBefore(Date date);

    Manufacturer findDistinctManifacturerByNameLike(String name);

}
