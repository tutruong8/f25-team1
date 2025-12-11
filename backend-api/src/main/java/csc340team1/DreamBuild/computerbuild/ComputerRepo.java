package csc340team1.DreamBuild.computerbuild;
import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepo extends JpaRepository<Computer, Long> {
    @Query(value = "Select * from computer_builds s where s.builder_id = ?1", nativeQuery = true)
    List<Computer> findByBuilderID(Long builderId);
}