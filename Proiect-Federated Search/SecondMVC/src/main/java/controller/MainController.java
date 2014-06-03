package controller;

import models.mergeData.MovieData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CleanupService;
import service.MainService;

import java.util.List;

/**
 * Created by cudrescu on 5/26/2014.
 */
@Controller
@RequestMapping("/")
public class MainController {

    private List<MovieData> movieDataList;
    private static boolean cleanupInitiated = false;
    private static final int elementsPerPage = 6;

    @Autowired
    MainService mainService;

    @Autowired
    CleanupService cleanupService;

    @RequestMapping(method = RequestMethod.GET)
    public String getSearch(){
        return "search";
    }

    @RequestMapping(value="home", method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }

    @RequestMapping(value="contact", method = RequestMethod.GET)
    public String getContact() {
        return "contact";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postSearch(@RequestBody String movieName ,ModelMap model) {

        if(!cleanupInitiated){
            Thread cleanupThread = new Thread(cleanupService);
            cleanupThread.start();
            cleanupInitiated = true;
        }

        Thread executionThread = new Thread(mainService);
        mainService.setMovieName(movieName.substring(6));

        executionThread.start();
        try {
            executionThread.join();
        } catch (InterruptedException e) {}

        movieDataList = mainService.getMovieDataList();

        model.addAttribute("list", movieDataList);
        model.addAttribute("size", movieDataList.size()/elementsPerPage+1);

        return "result";
    }



}
