package com.epam.msf2;

import com.epam.msf2.dps.Navigation;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SampleTest {
    private final static String URL = "http://amers1.msf2-09.cp.icp2.mpp.ime.reuters.com/msf";

    private MockMvc mockMvc;
    private RestTemplate restTemplate;

    @Autowired

    //Add WebApplicationContext field here.
    //The setUp() method is omitted.

    @Test
    public void verificationSimpleRequest() throws Exception {


        Map<String, String> map = new HashMap<String, String>();
        map.put("Ticker", "IBM.N");
        map.put("TickerType", "RIC");
        restTemplate.getForEntity(URL, Navigation.class, map);

    }

    @Test
    public void testMyMethod() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Ticker", "IBM.N");
        map.put("TickerType", "RIC");
        Gson gson = new Gson();
        String json = gson.toJson(map);
        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("foo=bar&fruit=apple"))
                .andExpect(content().string("foo=bar&fruit=apple"))
                .andDo(print());
    }
}
