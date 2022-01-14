package com.openapi.naverdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    private String groupName2;

    private String keyWords2;

}
