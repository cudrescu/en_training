package controller;

import models.rageTV.RageTVData;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.MovieService;

import java.io.IOException;

/**
 * Created by cudrescu on 5/26/2014.
 */
@Controller
@RequestMapping("/callback")
public class CallbackController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void getAnswer(@RequestBody String info){
        movieService.setAnswerFromCallbackServer(parseData(info));
    }

    private RageTVData[] parseData(String toParse){

        ObjectMapper mapper = new ObjectMapper();
        RageTVData[] rageTVData = null;

        try {
            rageTVData = mapper.readValue(toParse, RageTVData[].class);
        } catch (JsonGenerationException e) {
        } catch (JsonMappingException e) {
        } catch (IOException e) {
        }

        return rageTVData;
    }
}
