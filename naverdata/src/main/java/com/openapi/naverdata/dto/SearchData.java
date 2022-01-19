package com.openapi.naverdata.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchData {
    /*
  "startDate": "2017-01-01",
  "endDate": "2017-04-30",
  "timeUnit": "month",
  "groupName1”: "한글",
  "keywords1”: "한글",
  "groupName2”: "한글",
  "keywords2”: "한글"
     */

    private String startDate;

    private String endDate;

    private String timeUnit;

    private String groupName1;

    private String keyWords1;

}
