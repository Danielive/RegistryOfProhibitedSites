package live.daniel.webapps.persistence;

import live.daniel.webapps.model.Registry;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Daniel on 29.09.2017.
 */
public interface RegistryRepository extends CrudRepository<Registry, Long> {
}
