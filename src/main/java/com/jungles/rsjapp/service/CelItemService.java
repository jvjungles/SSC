package com.jungles.rsjapp.service;

import com.jungles.rsjapp.domain.CelItem;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link CelItem}.
 */
public interface CelItemService {
    CelItem save(CelItem celItem);

    CelItem update(CelItem celItem);

    Optional<CelItem> partialUpdate(CelItem celItem);

    List<CelItem> findAll();

    Optional<CelItem> findOne(Long id);

    void delete(Long id);
}
