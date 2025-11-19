package csc340team1.DreamBuild.builder;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BuilderRepo extends JpaRepository<Builder, Long> {
    @Query(value = "Select * from builders s where s.name like CONCAT('%',?1,'%')", nativeQuery = true)
    List<Builder> findByName(String name);

    @Query(value = "Select * from builders s where s.email like CONCAT('%',?1,'%')", nativeQuery = true)
    Optional<Builder> findByEmail(String email);
    boolean existsByEmail(String email);

    @Query(value = "Select * from builders s where s.address like CONCAT('%',?1,'%')", nativeQuery = true)
    List<Builder> findByAddress(String address);
}
