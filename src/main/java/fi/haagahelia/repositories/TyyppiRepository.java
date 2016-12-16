package fi.haagahelia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fi.haagahelia.models.Tyyppi;

public interface TyyppiRepository extends JpaRepository<Tyyppi, Integer> {

}
