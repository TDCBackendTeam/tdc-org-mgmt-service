package com.mmc.app.platform.service;

import com.mmc.app.platform.entity.HeadOffice;
import com.mmc.app.platform.exception.HeadOfficeExistsException;
import com.mmc.app.platform.repo.HeadOfficeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadOfficeServiceImpl implements HeadOfficeService{
    private static final Logger logger = LoggerFactory.getLogger(HeadOfficeServiceImpl.class);
    @Autowired
    private HeadOfficeRepository headOfficeRepository;

    public HeadOffice createHeadOffice(HeadOffice headOffice) throws HeadOfficeExistsException {
        boolean headOfficeExists = headOfficeRepository.existsAnyHeadOffice();
        if (!headOfficeExists) {
            logger.debug("No existing head office record found, proceeding to create");
            // No existing head office record found, proceed to create
            return headOfficeRepository.save(headOffice);
        }
        else {
            logger.info("Head office record already exists, returning existing record");
            // Head office record already exists, return existing record
            throw new HeadOfficeExistsException();
        }
    }

    public List<HeadOffice> getAllHeadOffices() {
        return headOfficeRepository.findAll();
    }

    public void deleteHeadOffice(Long id) {
        logger.info("Deleting head office with ID: {}", id);
        headOfficeRepository.deleteById(id);
    }

}
