package com.mmc.app.platform.service;

import com.mmc.app.platform.entity.Institute;
import com.mmc.app.platform.exception.PinExistsException;

import java.util.List;

public interface InstituteService {
    Institute createInstitute(Institute institute) throws PinExistsException;

    List<Institute> getAllInstitutes();

    void deleteInstitute(int id);

    Institute updateInstitute(int id, Institute updatedInstitute);
}
