package com.openapi.naverdata.service;

import com.openapi.naverdata.dto.ResultDataDto;
import com.openapi.naverdata.dto.ResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ParsingService {

    public ResultDto jsonParse(String jsonFile) {
        ResultDto resultDto = new ResultDto();
        ResultDataDto resultDataDto;
        try {

            JSONParser jsonParser = new JSONParser();

            //JSON데이터를 넣어 JSON Object 로 만들어 준다.
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonFile);

            //books의 배열을 추출
            JSONArray ResultInfoArray = (JSONArray) jsonObject.get("results");

            for(int i=0; i< ResultInfoArray.size(); i++){


                //배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
                JSONObject dataObject = (JSONObject) ResultInfoArray.get(i);

                log.info(dataObject);

                String title = (String) dataObject.get("title");

                log.info(title);

                JSONArray array = (JSONArray) dataObject.get("keywords");

                String keyword = (String) array.get(0);

               resultDto = ResultDto.builder()
                        .title(title)
                        .keywords(keyword)
                        .build();

                JSONArray dataInfoArray = (JSONArray) dataObject.get("data");
                log.info(dataInfoArray);
                List<ResultDataDto> temporaryList = new ArrayList<>();

                for (int j = 0; j < dataInfoArray.size(); j++) {
                    JSONObject rdateOject = (JSONObject) dataInfoArray.get(i);
                    String period = (String) rdateOject.get("period");
                    double ratio = Double.parseDouble((String)rdateOject.get("ratio"));
                    int ratioInt = (int)ratio;

                    resultDataDto = ResultDataDto
                            .builder()
                            .period(period)
                            .ratio(ratioInt)
                            .build();

                    temporaryList.add(resultDataDto);

                }
                resultDto.setDataDtoList(temporaryList);
            }



        } catch(ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultDto;
    }
}
