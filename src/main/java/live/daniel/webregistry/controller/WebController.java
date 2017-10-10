package live.daniel.webregistry.controller;

import live.daniel.webregistry.model.Registry;
import live.daniel.webregistry.service.WebService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("/registry")
    public String showRegistry(){
        return "registry";
    }

    //ftl
    @RequestMapping("/addsite")
    public String showAddSite(){
        return "addSite";
    }

    @RequestMapping("/add")
    public void addSite(@RequestParam("link") String link, @RequestParam("ip") String ip, @RequestParam("date") String date){
        service.addSite(link, ip, date);
    }

    //jsp
    @RequestMapping(value = "/deletesite", method = RequestMethod.GET)
    public ModelAndView getdata() {
        ModelAndView model = new ModelAndView("deleteSite");
        List<Registry> list = new ArrayList<>();
        String strJson = service.findAll();
        JSONObject dataJsonObj;
        String link;
        Long id;

        strJson = strJson.replace("[", "{\"sites\":[");
        strJson = strJson.replace("]", "]}");

        try {
            dataJsonObj = new JSONObject(strJson);
            JSONArray sites = dataJsonObj.getJSONArray("sites");

            for (int i = 0; i < sites.length(); i++) {
                JSONObject getSite = sites.getJSONObject(i);
                id = getSite.getLong("id");
                link = getSite.getString("link");
                list.add(new Registry(id, link, "", ""));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Map<String,Object> allSites = new HashMap<>();
        allSites.put("allSites", list);
        model.addAllObjects(allSites);

        return model;
    }

    @RequestMapping(value="/deletesite", method = RequestMethod.POST)
    public String postDelete(@RequestParam String id) {
        service.delSite(Long.valueOf(id));
        return "registry";
    }
}
