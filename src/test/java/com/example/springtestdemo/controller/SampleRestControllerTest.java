package com.example.springtestdemo.controller;

import com.example.springtestdemo.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
//mock안쓰고 진짜 servlet(내장톰캣)띄워서 처리하기
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//restTemplete, restTemplate, testWebClient로 써야함
public class SampleRestControllerTest {
    @Autowired
    //이렇게하면 서비스까지 간다.. 너무 테스트 케이스가 커진다.
            TestRestTemplate testRestTemplate;

    //sampleservice bean을  mocksampleservice bean으로 교체함..
    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("055055");

        String result = testRestTemplate.getForObject("/hello", String.class);
        assertThat(result).isEqualTo("hello055055");
    }
}
