package csc340team1.DreamBuild.builder;
import java.util.*;
import java.io.IOException;
import java.io.File;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class BuilderService {
    @Autowired
    private BuilderRepo builderRepo;

    /**
   * Method to get all builders in the database
   * @return list of builders in database
   */
    public List<Builder> getAllBuilders() {
        return builderRepo.findAll();
    }

    /**
   * Method to get builder by ID in the database
   * @param id ID of the builder to get
   * @return builder with the specified ID
   */
    public Builder getBuilderById(long id) {
        return builderRepo.findById(id).orElse(null);
    }

    /**
   * Method to get builder by email in the database
   * @param email email of the builder to get
   * @return builder with the specified email
   */
    public Object getBuilderByEmail(@PathVariable String email) {
        return builderRepo.findByEmail(email);
    }

    /**
   * Method to create new builder in the database
   * @param builder Builder to create
   * @return created builder
   */
    public Builder createBuilder(Builder builder) {
        return builderRepo.save(builder);
    }

    /**
   * Method to update builder in the database
   * @param id ID of the builder to update
   * @param updatedBuilder updated builder information
   * @return updated builder
   */
    public Builder updateBuilder(Long id, Builder updatedBuilder) {
        return builderRepo.findById(id).map(builder -> {
            builder.setName(updatedBuilder.getName());
            builder.setEmail(updatedBuilder.getEmail());
            builder.setPassword(updatedBuilder.getPassword());
            builder.setAddress(updatedBuilder.getAddress());
            return builderRepo.save(builder);
        }).orElseGet(() -> {
            updatedBuilder.setId(id);
            return builderRepo.save(updatedBuilder);
        });
    }

    /**
   * Method to delete builder in the database
   * @param id ID of the builder to delete
   */
    public void deleteBuilder(Long id) {
        builderRepo.deleteById(id);
    }

    /**
     * Method to authenticate a builder
     * */
    public Builder authenticate(String email, String password) {
        Builder builder = builderRepo.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Builder not found with the email you just typed! Try again."));
        if (!builder.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid email or password! Try again.");
        }
        return builder;
    }
    
    /**
   * Method to write builder to JSON file
   * @param builder Builder to write
   */
    public String writeJson(Builder builder) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("builder.json"), builder);
        return "Builder has been written to JSON file";
    }

    /**
   * Method to read builder in the database
   * @param builder Builder to read
   * @return contents in JSON
   */
    public Builder readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("builder.json"), Builder.class);
    }
}
