package com.openapi.naverdata.service;

import com.openapi.naverdata.dto.ResultDto;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ParsingService.class)
public class ParsingServiceTest {

    @Autowired
    private ParsingService parsingService;

    @Test
    public void parsingTest() {
        String jsonObject = "{\"startDate\":\"2017-01-01\"," +
        "\"endDate\":\"2017-04-30\"," +
        "\"timeUnit\":\"month\"," +
        "\"results\":[{\"title\": \"game\"," +
        "\"keywords\":[\"LostArk\"]," + 
        "\"data\":[{ \"period\": \"2017-01-01\"," + "\"ratio\":\"67.41996\"}," +
        "{\"period\":\"2017-02-01\"," + "\"ratio\":\"68.17325\"}," +
        "{ \"period\":\"2017-03-01\"," + "\"ratio\":\"100\"},"+
        "{\"period\":\"2017-04-01\"," + "\"ratio\":\"66.10169\"}]}]}";
        
        ResultDto testResultDto = parsingService.jsonParse(jsonObject);
        
        assertThat(testResultDto.getTitle()).isEqualTo("game");
        assertThat(testResultDto.getKeywords()).isEqualTo("LostArk");
        assertThat(testResultDto.getDataDtoList()).isNotNull();
   }
}
