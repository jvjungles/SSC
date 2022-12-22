package com.jungles.rsjapp.web.rest;

import com.jungles.rsjapp.domain.CelItem;
import com.jungles.rsjapp.repository.CelItemRepository;
import com.jungles.rsjapp.service.CelItemService;
import com.jungles.rsjapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.jungles.rsjapp.domain.CelItem}.
 */
@RestController
@RequestMapping("/api")
public class CelItemResource {

    private final Logger log = LoggerFactory.getLogger(CelItemResource.class);

    private static final String ENTITY_NAME = "celItem";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CelItemService celItemService;

    private final CelItemRepository celItemRepository;

    public CelItemResource(CelItemService celItemService,
            CelItemRepository celItemRepository) {
        this.celItemService = celItemService;
        this.celItemRepository = celItemRepository;
    }

    @PostMapping("/celItem")
    public ResponseEntity<CelItem> createCelItem(@RequestBody CelItem celItem) throws URISyntaxException {
        
        log.debug("REST request to save CelItem : {}", celItem);
        
        if (celItem.getId() != null) {
            throw new BadRequestAlertException("A new celItem cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CelItem result = celItemService.save(celItem);
        return ResponseEntity
                .created(new URI("/api/celItem/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME,
                        result.getId().toString()))
                .body(result);
    }

    @PutMapping("/celItem/{id}")
    public ResponseEntity<CelItem> updateCelItem(
                @PathVariable(value = "id", required = false) final Long id,
                @RequestBody CelItem celItem) throws URISyntaxException {
        
        log.debug("REST request to update CelItem : {}, {}", id, celItem);
        
        if (celItem.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, celItem.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!celItemRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CelItem result = celItemService.update(celItem);
        return ResponseEntity
                .ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME,
                        celItem.getId().toString()))
                .body(result);
    }

    @PatchMapping(value = "/celItem/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<CelItem> partialUpdateCelItem(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody CelItem celItem) throws URISyntaxException {
        
        log.debug("REST request to partial update CelItem partially : {}, {}", id, celItem);
        
        if (celItem.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, celItem.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!celItemRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CelItem> result = celItemService.partialUpdate(celItem);

        return ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, celItem.getId().toString()));
    }

    @GetMapping("/celItem")
    public List<CelItem> getAllCelItem() {
        
        log.debug("REST request to get all CelItem");
        
        return celItemService.findAll();
    }

    @GetMapping("/celItem/{id}")
    public ResponseEntity<CelItem> getCelItem(@PathVariable Long id) {
        
        log.debug("REST request to get CelItem : {}", id);
        
        Optional<CelItem> celItem = celItemService.findOne(id);
        return ResponseUtil.wrapOrNotFound(celItem);
    }

    @DeleteMapping("/celItem/{id}")
    public ResponseEntity<Void> deleteCelItem(@PathVariable Long id) {
        
        log.debug("REST request to delete CelItem : {}", id);
        
        celItemService.delete(id);
        return ResponseEntity
                .noContent()
                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                .build();
    }
}
