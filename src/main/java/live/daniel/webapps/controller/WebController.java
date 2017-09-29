package live.daniel.webapps.controller;

import live.daniel.webapps.model.Registry;
import live.daniel.webapps.persistence.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Daniel on 29.09.2017.
 */
@RestController
public class WebController {
    @Autowired
    RegistryRepository repository;

    @RequestMapping("/save")
    public String process(){
        repository.save(new Registry("warungharta.com", "103.11.40.1", "29.09.2017"));
        repository.save(new Registry("unibet.com.au", "103.227.169.1", "29.09.2017"));
        repository.save(new Registry("kupitmagnit.net", "184.168.221.12", "29.09.2017"));
        repository.save(new Registry("slotvalue2016.ru", "185.43.222.89", "14.09.2017"));
        repository.save(new Registry("sitemarathon.win", "88.150.168.144", "14.09.2017"));
        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll(){
        String result = "<html>";

        for(Registry registry : repository.findAll()){
            result += "<div>" + registry.toString() + "</div>";
        }

        return result + "</html>";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }

    @RequestMapping("/findbyLink")
    public String fetchDataByLink(@RequestParam("link") String link){
        String result = "<html>";

        for(Registry registry: repository.findByLink(link)){
            result += "<div>" + registry.toString() + "</div>";
        }

        return result + "</html>";
    }

    @RequestMapping("/deleteall")
    public String findAllAndDelete(){
        String result = "check";
        repository.deleteAll();
        return result = "done";
    }
}
