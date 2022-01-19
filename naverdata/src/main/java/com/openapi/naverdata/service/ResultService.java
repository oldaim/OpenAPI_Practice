package com.openapi.naverdata.service;

import com.openapi.naverdata.dto.ResultDataDto;
import com.openapi.naverdata.dto.ResultDto;
import com.openapi.naverdata.entity.Result;
import com.openapi.naverdata.entity.ResultData;
import com.openapi.naverdata.repository.DataRepository;
import com.openapi.naverdata.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ResultService {

    private final ResultRepository resultRepository;
    private final DataRepository dataRepository;

    public Long save(ResultDto dto){

        Result result = Result.builder()
                .title(dto.getTitle())
                .keyword(dto.getKeywords())
                .build();

        resultRepository.save(result);


        for (int i = 0; i < dto.getDataDtoList().size(); i++) {
            ResultDataDto dataDto = dto.getDataDtoList().get(i);
            ResultData resultData = ResultData.builder()
                    .result(result)
                    .period(dataDto.getPeriod())
                    .ratio(dataDto.getRatio())
                    .build();

            dataRepository.save(resultData);
        }
        return result.getId();
    }


    public void delete(){

    }
}
