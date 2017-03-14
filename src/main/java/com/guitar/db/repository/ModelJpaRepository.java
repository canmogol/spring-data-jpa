package com.guitar.db.repository;

import com.guitar.db.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ModelJpaRepository extends JpaRepository<Model, Long> {

    List<Model> findByPriceLessThanEqualAndPriceGreaterThanEqual(
            BigDecimal less, BigDecimal greater
    );

    List<Model> findByModelTypeNameIn(List<String> types);

    @Query(
            value = "select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood",
            nativeQuery = false
    )
    List<Model> queryByPriceRangeAndWoodType(
            @Param("lowest") BigDecimal decimal1,
            @Param("highest") BigDecimal decimal2,
            @Param("wood") String s);


    @Modifying
    @Query(value = "update Model m set m.name = ?1 where m.id = ?2")
    int updateByName(String name, Long id);

    // named query defined in Model class is "Model.findAllModelsByType"
    // the first part "Model." is the generic type of this repository
    // the second part ".findAllModelsByType" is the part of the method after the "named" prefix
    List<Model> namedfindAllModelsByType(@Param("name") String type);


    // otherwise you can set the named query to the Query annotation as follows
    @Query(name = "Model.findAllModelsByType")
    List<Model> findTypesUsingNamedQuery(@Param("name") String type);

}
