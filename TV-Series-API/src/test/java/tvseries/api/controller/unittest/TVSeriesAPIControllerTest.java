package tvseries.api.controller.unittest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import tvseries.api.DataLoader;
import tvseries.api.TVSeries;
import tvseries.api.TVSeriesService;
import tvseries.api.controller.TVSeriesAPIController;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TVSeriesAPIController.class)
public class TVSeriesAPIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TVSeriesService tvSeriesService;

    private ObjectMapper objectMapper;

    private List<TVSeries> tvSeries;

    @Before
    public void setUp(){
        tvSeries = DataLoader.loadTVSeries();
    }

    @Test
    public void getAllTVSeriesTest() throws Exception{
        when(tvSeriesService.getAllTVSeries(null, null)).thenReturn(tvSeries);
        when(tvSeriesService.getAllTVSeries("Drama", null)).thenReturn(null);

        MvcResult result = mockMvc.perform(get("/tv-series")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk()).andReturn();

        System.out.println("\n*************************RESPONSE BODY**************************************");
        System.out.println(result.getResponse().getContentAsString() + "\n");
    }

}