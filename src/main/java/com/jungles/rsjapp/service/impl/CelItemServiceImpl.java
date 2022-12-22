package com.jungles.rsjapp.service.impl;

import com.jungles.rsjapp.domain.CelItem;
import com.jungles.rsjapp.repository.CelItemRepository;
import com.jungles.rsjapp.service.CelItemService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CelItem}.
 */
@Service
@Transactional
public class CelItemServiceImpl implements CelItemService {

    private final Logger log = LoggerFactory.getLogger(CelItemServiceImpl.class);

    private final CelItemRepository celItemRepository;

    public CelItemServiceImpl(CelItemRepository celItemRepository) {
        this.celItemRepository = celItemRepository;
    }

    @Override
    public CelItem save(CelItem celItem) {
        log.debug("Request to save CelItem : {}", celItem);
        return celItemRepository.save(celItem);
    }

    @Override
    public CelItem update(CelItem celItem) {
        log.debug("Request to update CelItem : {}", celItem);
        return celItemRepository.save(celItem);
    }

    @Override
    public Optional<CelItem> partialUpdate(CelItem celItem) {
        log.debug("Request to partially update CelItem : {}", celItem);

        return celItemRepository
            .findById(celItem.getId())
            .map(existingRegion -> {
                if (celItem.getCelItemName() != null) {
                    existingRegion.setCelItemName(celItem.getCelItemName());
                }

                return existingRegion;
            })
            .map(celItemRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CelItem> findAll() {
        log.debug("Request to get all CelItems");
        return celItemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CelItem> findOne(Long id) {
        log.debug("Request to get CelItem : {}", id);
        return celItemRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CelItem : {}", id);
        celItemRepository.deleteById(id);
    }
}
