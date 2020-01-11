package manager;

import model.Personnage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by Quentin on 03/11/2017.
 */
@CrossOrigin
public interface PersonnageRepository extends CrudRepository <Personnage, Integer> {
}
