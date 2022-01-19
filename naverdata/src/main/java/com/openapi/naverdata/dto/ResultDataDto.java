package com.openapi.naverdata.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResultDataDto {
    private String period;

    private int ratio;
}
