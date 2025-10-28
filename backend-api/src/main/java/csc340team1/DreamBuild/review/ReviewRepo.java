package csc340team1.DreamBuild.review;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
    @Query(value = "Select * from reviews s where s.builder_id = ?1", nativeQuery = true)
    List<Review> findByBuilderId(Long builderId);

    @Query(value = "Select * from reviews s where s.computer_id = ?1", nativeQuery = true)
    List<Review> findByComputerId(Long computerId);
}
