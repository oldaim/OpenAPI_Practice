package com.openapi.naverdata.repository;

import com.openapi.naverdata.entity.ResultData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<ResultData,Long> {
}
