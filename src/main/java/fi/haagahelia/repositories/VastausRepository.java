package fi.haagahelia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fi.haagahelia.models.Vastaus;

public interface VastausRepository extends JpaRepository<Vastaus, Integer> { 


}
