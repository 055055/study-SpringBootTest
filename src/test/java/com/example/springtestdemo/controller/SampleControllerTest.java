package com.example.springtestdemo.controller;

import com.example.springtestdemo.service.SampleService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//servelet안띄우고 mock으로 처리하기

//가장 기본적인 형태의 테스트 코드
@RunWith(SpringRunner.class)
//springbootTest는 mock이 기본 값이다.       springbootTest는 springApplicationTest로 가서 모든 bean을 다 찾아서.. mock빈으로 교체하고 그런다
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//mocMvc만들기
@AutoConfigureMockMvc
public class SampleControllerTest {
    //log를 포함하여 콘솔에 찍히는 모든 걸 캡쳐한다.
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("helloseungik"))
                .andDo(print());
    }
}
