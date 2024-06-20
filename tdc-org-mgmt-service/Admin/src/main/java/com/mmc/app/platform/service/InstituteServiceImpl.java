package com.mmc.app.platform.service;

import com.mmc.app.platform.entity.Institute;
import com.mmc.app.platform.exception.PinExistsException;
import com.mmc.app.platform.repo.InstituteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteServiceImpl implements InstituteService{
    private static final Logger logger = LoggerFactory.getLogger(InstituteServiceImpl.class);
    @Autowired
    private InstituteRepository instituteRepository;

    public Institute createInstitute(Institute institute) throws PinExistsException {
        if (instituteRepository.existsByPin(institute.getPin())) {
            logger.error("Institute creation failed due to duplicate PIN: {}", institute.getPin());
            throw new PinExistsException();
        }
        logger.info("Creating new institute: {}", institute.getName());
        return instituteRepository.save(institute);
    }


    public List<Institute> getAllInstitutes() {
        logger.info("Retrieving all institutes.");
        return instituteRepository.findAll();
    }
    public List<String> getInstituteCodes() {
        logger.info("Retrieving all institutes names.");
        return instituteRepository.getInstituteCodes();
    }

    public void deleteInstitute(int id) {
        logger.info("Deleting institute with ID: {}", id);
        instituteRepository.deleteById(id);
    }

    public Institute updateInstitute(int id, Institute updatedInstitute) {
        Institute existingInstitute = instituteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Institute not found with id: " + id));

        // Update the existing Institute's attributes with the new values
        logger.info("Updating institute with ID: {}", id);
        existingInstitute.setCode(updatedInstitute.getCode());
        existingInstitute.setName(updatedInstitute.getName());
        existingInstitute.setAddress(updatedInstitute.getAddress());
        existingInstitute.setCity(updatedInstitute.getCity());
        existingInstitute.setState(updatedInstitute.getState());
        existingInstitute.setCountry(updatedInstitute.getCountry());
        existingInstitute.setPin(updatedInstitute.getPin());
        existingInstitute.setPhone(updatedInstitute.getPhone());
        existingInstitute.setFax(updatedInstitute.getFax());
        existingInstitute.setEmail(updatedInstitute.getEmail());
        existingInstitute.setManager(updatedInstitute.getManager());

        // Save and return the updated Institute
        return instituteRepository.save(existingInstitute);
    }



}
