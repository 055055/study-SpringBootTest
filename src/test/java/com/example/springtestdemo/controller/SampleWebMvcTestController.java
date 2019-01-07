package com.example.springtestdemo.controller;


import com.example.springtestdemo.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/*SpringBootTest는 전체 빈을 다 찾아서 등록하기 때문에 대규모이다.

        내가 원하는 빈만 등록해서 테스트 하고 싶다면, 슬라이스Test로 할 수 있다.
        레이어 별로 잘라서 테스트하고 싶을 떄

@WebMvcTest 내가 원하는 controller하나만 테스트할 수 잇다.
        웹과 관련된 애들만 빈으로 등록된다.. service같은 애들은 bean으로 등록이 안되기 때문애
        의존성이 끊길 수 있다.. 사용하는 의존성이 있다면 mockbean으로 만들어서 채워줘야 한다.

        webMvcTest는 항상 mockMvc로 테스트 해야 한다.*/

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleWebMvcTestController {
    @MockBean
    SampleService mockSampleService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("055055");
        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hello055055"));
    }

}
