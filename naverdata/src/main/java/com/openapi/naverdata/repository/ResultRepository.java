package com.openapi.naverdata.repository;

import com.openapi.naverdata.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository <Result,Long> {
}
