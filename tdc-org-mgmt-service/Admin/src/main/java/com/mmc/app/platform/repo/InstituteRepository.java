package com.mmc.app.platform.repo;

import com.mmc.app.platform.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, Integer> {
    boolean existsByPin(String pin);

    @Query("select i.code from Institute i")
    List<String> getInstituteCodes();
}
