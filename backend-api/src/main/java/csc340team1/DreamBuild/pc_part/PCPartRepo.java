
package csc340team1.DreamBuild.pc_part;

import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PCPartRepo extends JpaRepository<PCPart, Long> {
    @Query(value = "Select * from pc_parts s where s.builder_id = ?1", nativeQuery = true)
    List<PCPart> findByBuilderID(Long builderId);

    @Query(value = "Select * from pc_parts s where s.part_type = ?1", nativeQuery = true)
    List<PCPart> findByPartType(String partType);
}
