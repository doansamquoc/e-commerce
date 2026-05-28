package org.sam.ecommerce.repository;

import org.sam.ecommerce.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query("SELECT i.id FROM Image i WHERE i.id IN :ids")
    List<Long> findExistingIdsIn(Set<Long> ids);
}
