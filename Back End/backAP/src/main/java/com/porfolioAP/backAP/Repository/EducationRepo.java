package com.porfolioAP.backAP.Repository;

import com.porfolioAP.backAP.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepo extends JpaRepository<Education, Long> {
}
