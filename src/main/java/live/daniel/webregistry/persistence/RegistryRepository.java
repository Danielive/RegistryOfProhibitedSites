package live.daniel.webregistry.persistence;

import live.daniel.webregistry.model.Registry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Daniel on 29.09.2017.
 */
public interface RegistryRepository extends CrudRepository<Registry, Long> {
    List<Registry> findAllByLink(String link);
}
