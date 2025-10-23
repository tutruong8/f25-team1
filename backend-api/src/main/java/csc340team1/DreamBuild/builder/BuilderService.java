package csc340team1.DreamBuild.builder;
import java.util.*;
import java.io.IOException;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class BuilderService {
    @Autowired
    private BuilderRepo builderRepo;

    public List<Builder> getAllBuilders() {
        return builderRepo.findAll();
    }

    public Object getBuilderById(@PathVariable long id) {
        return builderRepo.findById(id);
    }

    public Object getBuilderByName(@PathVariable String name) {
        return builderRepo.findByName(name);
    }

    public Object getBuilderByEmail(@PathVariable String email) {
        return builderRepo.findByEmail(email);
    }

    public Object getBuilderByAddress(@PathVariable String address) {
        return builderRepo.findByAddress(address);
    }

    public Builder createBuilder(Builder builder) {
        return builderRepo.save(builder);
    }

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

    public void deleteBuilder(Long id) {
        builderRepo.deleteById(id);
    }
    
    /**
   * Method to write animal to JSON file
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
