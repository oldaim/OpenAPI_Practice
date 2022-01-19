package com.openapi.naverdata.service;

import com.openapi.naverdata.dto.ResultDto;
import com.openapi.naverdata.entity.Result;
import com.openapi.naverdata.repository.ResultRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ResultServiceTest {

    @Autowired
    ResultRepository resultRepository;
    @Autowired
    ParsingService parsingService;
    @Autowired
    ResultService resultService;


    @Test
    public void SaveTest(){
        //given
        String jsonObject = "{\"startDate\":\"2017-01-01\"," +
                "\"endDate\":\"2017-04-30\"," +
                "\"timeUnit\":\"month\"," +
                "\"results\":[{\"title\": \"game\"," +
                "\"keywords\":[\"LostArk\"]," +
                "\"data\":[{ \"period\": \"2017-01-01\"," + "\"ratio\":\"67.41996\"}," +
                "{\"period\":\"2017-02-01\"," + "\"ratio\":\"68.17325\"}," +
                "{ \"period\":\"2017-03-01\"," + "\"ratio\":\"100\"},"+
                "{\"period\":\"2017-04-01\"," + "\"ratio\":\"66.10169\"}]}]}";

        //when
        ResultDto resultDto = parsingService.jsonParse(jsonObject);
        Long id = resultService.save(resultDto);
        Optional<Result> dummyResult = resultRepository.findById(id);

        //that
        if(dummyResult.isPresent()) {
            assertThat(dummyResult.get().getTitle()).isEqualTo(resultDto.getTitle());
            assertThat(dummyResult.get().getKeyword()).isEqualTo(resultDto.getKeywords());
        }
        else{
            fail("Test is fail");
        }
    }

}
