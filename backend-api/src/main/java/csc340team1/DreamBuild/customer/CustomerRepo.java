package csc340team1.DreamBuild.customer;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    @Query(value = "Select * from customer s where s.name like CONCAT('%',?1,'%')", nativeQuery = true)
    List<Customer> findByName(String name);

    @Query(value = "Select * from customer s where s.email like CONCAT('%',?1,'%')", nativeQuery = true)
    Optional<Customer> findByEmail(String email);
    boolean existsByEmail(String email);

    @Query(value = "Select * from customer s where s.address like CONCAT('%',?1,'%')", nativeQuery = true)
    List<Customer> findByAddress(String address);
}