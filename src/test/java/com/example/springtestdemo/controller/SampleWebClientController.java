package com.example.springtestdemo.controller;

import com.example.springtestdemo.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.WebClientRestTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
//mock안쓰고 진짜 servlet(내장톰캣)띄워서 처리하기
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//restTemplete, restTemplate, testWebClient로 써야함
public class SampleWebClientController {
   //이거 쓰려면 webflux dependency 추가해야한다.
    @Autowired
    WebTestClient webTestClient;
    //restClient중 하나인데, 기존은 sync라서 요청하나 끝날 때 까지 기다려야 하는데, webClient는 async이다.

    //sampleservice bean을  mocksampleservice bean으로 교체함..
    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("055055");

        webTestClient.get().uri("/hello").exchange().expectStatus().isOk()
                            .expectBody(String.class).isEqualTo("hello055055");
    }
}
