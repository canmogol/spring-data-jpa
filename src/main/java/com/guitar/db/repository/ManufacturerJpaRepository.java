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

    // "Manufacturer.getAllThatSellAcoustics" is a native query
    // "Manufacturer." first part is the generic type of this repository
    // second part ".getAllThatSellAcoustics" is the native query name
    // match the name of this method to the native method and it should work
    List<Manufacturer> getAllThatSellAcoustics(String name);

}
