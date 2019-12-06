package tvseries.api.controller.unittest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
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

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TVSeriesAPIController.class)
public class TVSeriesAPIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TVSeriesService tvSeriesService;

    @Autowired
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

    @Test
    public void getTVSeriesTest() throws Exception {
        TVSeries expected = null;
        for(TVSeries tvShow : tvSeries){
            if(tvShow.getId() == 9){
                expected = tvShow; // Expected TV Series = Attack on Titan (It has ID 9 in test database)
            }
        }
        if(expected != null){
            when(tvSeriesService.getTVSeries(9)).thenReturn(expected);

            MvcResult result = mockMvc.perform(get("/tv-series/9")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn();

            String expectedJSON = objectMapper.writeValueAsString(expected);
            String controllerResponseJSON = result.getResponse().getContentAsString();
            JSONAssert.assertEquals(controllerResponseJSON, expectedJSON, true);
        } else {
            fail();
        }
    }

    @Test
    public void addTVSeriesTest() throws Exception {
        TVSeries testSeries = new TVSeries(1, "title", 0, "genre", "description");
        when(tvSeriesService.addTVSeries(testSeries)).thenReturn(true);

        MvcResult result = mockMvc.perform(post("/tv-series")
                .content(objectMapper.writeValueAsBytes(testSeries))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated()) // todo - fix java.lang.AssertionError on line 94
                .andReturn();
    }

    @Test
    public void deleteTVSeries() throws Exception {
        when(tvSeriesService.deleteTVSeries(1)).thenReturn(true);

        MvcResult result = mockMvc.perform(delete("/tv-series")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

}