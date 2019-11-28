package tvseries.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tvseries.api.DataLoader;
import tvseries.api.TVSeries;
import tvseries.api.TVSeriesService;

import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TVSeriesAPIController.class)
public class TVSeriesAPIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private TVSeriesService tvSeriesService;

    private List<TVSeries> tvSeries;


    @Test
    public void getAllTVSeriesTest() throws Exception{
        tvSeries = DataLoader.loadTVSeries();
    }

}