package com.test.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.cloud.entity.GcloudTestEntity;

@Repository
public interface GcloudTestRepository extends JpaRepository<GcloudTestEntity, Integer>{

}
