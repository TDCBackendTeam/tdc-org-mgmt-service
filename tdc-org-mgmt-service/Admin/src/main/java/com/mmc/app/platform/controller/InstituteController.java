package com.mmc.app.platform.controller;

import com.mmc.app.platform.entity.Institute;
import com.mmc.app.platform.exception.PinExistsException;
import com.mmc.app.platform.service.InstituteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institutes")
public class InstituteController {
    private static final Logger logger = LoggerFactory.getLogger(InstituteController.class);
    @Autowired
    private InstituteServiceImpl instituteServiceImpl;

    @PostMapping
    public ResponseEntity<Institute> createInstitute(@RequestBody Institute institute) throws PinExistsException {
        logger.info("Creating new institute: {}", institute.getName());
        Institute createdInstitute = instituteServiceImpl.createInstitute(institute);
        logger.info("Institute created successfully: {}", createdInstitute.getId());
        return new ResponseEntity<>(createdInstitute, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Institute> getAllInstitutes() {
        logger.info("Fetching all institutes");
        return instituteServiceImpl.getAllInstitutes();
    }
    @GetMapping("/name")
    public List<String> getAllInstitutesCode() {
        logger.info("Fetching all institutes");
        return instituteServiceImpl.getInstituteCodes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitute(@PathVariable int id) {
        logger.info("Deleting institute with ID: {}", id);
        instituteServiceImpl.deleteInstitute(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Institute> updateInstitute(@PathVariable int id, @RequestBody Institute institute) {
        logger.info("Updating institute with ID: {}", id);
        Institute updatedInstitute = instituteServiceImpl.updateInstitute(id, institute);
        if (updatedInstitute != null) {
            logger.info("Institute updated successfully: {}", updatedInstitute.getId());
            return new ResponseEntity<>(updatedInstitute, HttpStatus.OK);
        } else {
            logger.error("Institute not found with ID: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
