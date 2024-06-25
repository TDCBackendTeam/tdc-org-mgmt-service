package com.mmc.app.platform.service;

import com.mmc.app.platform.entity.HeadOffice;
import com.mmc.app.platform.exception.HeadOfficeExistsException;

import java.util.List;

public interface HeadOfficeService {
    HeadOffice createHeadOffice(HeadOffice headOffice) throws HeadOfficeExistsException;

    List<HeadOffice> getAllHeadOffices();

    void deleteHeadOffice(Long id);
}
