package com.openapi.naverdata.controller;

import com.openapi.naverdata.dto.ResultDto;
import com.openapi.naverdata.dto.SearchData;
import com.openapi.naverdata.service.JsonApiService;
import com.openapi.naverdata.service.ParsingService;
import com.openapi.naverdata.service.ResultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RequiredArgsConstructor
@RestController
@Log4j2
public class JsonController {

    private final JsonApiService jsonApiService;
    private final ParsingService parsingService;
    private final ResultService resultService;

    @RequestMapping(value = "/request",method = {RequestMethod.POST,RequestMethod.GET})
    public void callApi(@RequestBody SearchData data) {

        String clientId = ClientEnum.CLIENT_ID.getValue(); // 애플리케이션 클라이언트 아이디
        String clientSecret = ClientEnum.CLIENT_SECRET.getValue(); // 애플리케이션 클라이언트 시크릿

        Map<String, String> requestHeaders = Map.of(
                "X-Naver-Client-Id", clientId,
                "X-Naver-Client-Secret", clientSecret,
                "Content-Type", "application/json"
        );

        String apiUrl = "https://openapi.naver.com/v1/datalab/search";

        String requestBody = "{\"startDate\":\""+ data.getStartDate() + "\"," +
                "\"endDate\":\""+data.getEndDate()+"\"," +
                "\"timeUnit\":\""+data.getTimeUnit() +"\"," +
                "\"keywordGroups\":[{\"groupName\":\""+data.getGroupName1()+"\","
                + "\"keywords\":[\"" + data.getKeyWords1() +"\"]}]" + "}";



        String responseBody = jsonApiService.post(apiUrl, requestHeaders, requestBody);

        ResultDto resultDto = parsingService.jsonParse(responseBody);

        resultService.save(resultDto);

    }

}
