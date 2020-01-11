package manager;

import model.Realisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by Quentin on 03/11/2017.
 */
@CrossOrigin
public interface RealisateurRepository extends CrudRepository <Realisateur, Integer> {
}
