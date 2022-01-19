package com.openapi.naverdata.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {

    private String title;

    private String keywords;

    private List<ResultDataDto> dataDtoList = new ArrayList<>();

}
