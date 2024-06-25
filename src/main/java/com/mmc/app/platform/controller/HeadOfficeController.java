package com.mmc.app.platform.controller;

import com.mmc.app.platform.entity.HeadOffice;
import com.mmc.app.platform.exception.HeadOfficeExistsException;
import com.mmc.app.platform.service.HeadOfficeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/HeadOffice")
public class HeadOfficeController {
    private static final Logger logger = LoggerFactory.getLogger(HeadOfficeController.class);
    @Autowired
    private HeadOfficeServiceImpl headOfficeServiceImpl;

    @PostMapping
    public ResponseEntity<HeadOffice> createHeadOffice(@RequestBody HeadOffice headOffice) throws HeadOfficeExistsException {
           logger.info("Creating new head office: {}", headOffice.getName());
            HeadOffice createdHeadOffice = headOfficeServiceImpl.createHeadOffice(headOffice);
            logger.info("Head office created successfully: {}", createdHeadOffice.getId());
            return new ResponseEntity<>(createdHeadOffice, HttpStatus.CREATED);

    }
    @GetMapping("/all")
    public List<HeadOffice> getAllHeadOffices() {
        logger.info("Fetching all head offices");
        return headOfficeServiceImpl.getAllHeadOffices();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHeadOffice(@PathVariable Long id) {
        logger.info("Deleting head office with ID: {}", id);
        headOfficeServiceImpl.deleteHeadOffice(id);
        return ResponseEntity.noContent().build();
    }
}
