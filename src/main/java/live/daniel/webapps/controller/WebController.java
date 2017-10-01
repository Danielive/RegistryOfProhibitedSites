package live.daniel.webapps.controller;

import live.daniel.webapps.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Daniel on 29.09.2017.
 */
@Controller
public class WebController {

    @Autowired
    private WebService service;

    //get list sites
    @RequestMapping("/start")
    @ResponseBody
    public String getListOfRegistry() {
        return service.findAll();
    }

    //ftl
    @RequestMapping("/addsite")
    public String showAddSite(){
        return "addSite";
    }

    //ftl
    @RequestMapping("/registry")
    public String showRegistry(){
        return "registry";
    }

    @RequestMapping("/add")
    public void addSite(@RequestParam("link") String link, @RequestParam("ip") String ip, @RequestParam("date") String date){
        service.addSite(link, ip, date);
    }

    @RequestMapping("/delete")
    public void deleteAll(@RequestParam("id") long id){
        service.deleteById(id);
    }
}
