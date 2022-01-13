package com.openapi.naverdata.repository;

import com.openapi.naverdata.entity.ResultData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<ResultData,Long> {
}
