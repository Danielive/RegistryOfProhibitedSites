package live.daniel.webapps.service;

import live.daniel.webapps.model.Registry;
import live.daniel.webapps.persistence.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Daniel on 29.09.2017.
 */
@Service
public class WebService {
    @Autowired
    private RegistryRepository repository;

    public String findAll() {
        return repository.findAll().toString();
    }

    public List<Registry> findAllLink(String link) {
        return repository.findAllByLink(link);
    }

    public void addSite(String link, String ip, String date) {
        repository.save(new Registry(link, ip, date));
    }

    public void delSite(Long id) {
        repository.delete(id);
    }
}