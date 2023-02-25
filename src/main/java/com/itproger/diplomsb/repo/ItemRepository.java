package com.itproger.diplomsb.repo;

import com.itproger.diplomsb.models.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Reference, Long> {
    Reference findByShortref(String shortref);
}
