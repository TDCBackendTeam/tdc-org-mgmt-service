package com.mmc.app.platform.repo;

import com.mmc.app.platform.entity.HeadOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadOfficeRepository extends JpaRepository<HeadOffice, Long> {
    @Query("SELECT COUNT(h) > 0 FROM HeadOffice h")
    boolean existsAnyHeadOffice();
}
