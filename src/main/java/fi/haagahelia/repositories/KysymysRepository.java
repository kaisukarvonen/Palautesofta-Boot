package fi.haagahelia.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fi.haagahelia.models.Kysymys;

@Repository
public interface KysymysRepository extends JpaRepository<Kysymys, Integer> {

	int removeById(int kysymysId);
	
	@Modifying
	@Query("UPDATE kysymys SET kysymys_nimi = :kysymysNimi WHERE kysymys_id= :kysymysId")
	int updateKysymysNimi(@Param("kysymysId") int kysymysId, @Param("kysymysNimi") String kysymysNimi); 
  

}
