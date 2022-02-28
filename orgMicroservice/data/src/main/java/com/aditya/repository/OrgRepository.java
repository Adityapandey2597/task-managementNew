package com.aditya.repository;

import com.aditya.org_entities.OrgValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRepository extends JpaRepository<OrgValue,Long> {

}
