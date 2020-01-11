package manager;

import model.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Acteur.class);
        config.exposeIdsFor(Categorie.class);
        config.exposeIdsFor(Film.class);
        config.exposeIdsFor(Personnage.class);
        config.exposeIdsFor(Realisateur.class);

    }
}
