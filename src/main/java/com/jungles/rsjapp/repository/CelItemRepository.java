package com.jungles.rsjapp.repository;

import com.jungles.rsjapp.domain.CelItem;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CelItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CelItemRepository extends JpaRepository<CelItem, Long> {}
