package net.cvergara.springboot.repository;

import net.cvergara.springboot.entity.WikiMediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikiMediaData , Long> {
}
