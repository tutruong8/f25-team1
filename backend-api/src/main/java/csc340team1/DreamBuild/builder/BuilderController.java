package csc340team1.DreamBuild.builder;

import java.io.IOException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuilderController {
    @Autowired
    private BuilderService builderService;

    @GetMapping("/builder")
    
    /**
   * Endpoint to get all builders in the database
   *
   * @return List of all builders in the database
   */
    public List<Builder> getAllBuilders() {
        return builderService.getAllBuilders();
    }

    /**
   * Endpoint to get the desired builder through ID
   * @param id ID of the builder to get
   * @return The builder with the wanted ID
   */
    @GetMapping("/builder/{id}")
    public Object getBuilderById(@PathVariable long id) {
        return builderService.getBuilderById(id);
    }

    /**
   * Endpoint to get the desired builder through email
   * @param email Email of the builder to get
   * @return The builder with the wanted email
   */
    @GetMapping("/builder/email")
    public Object getBuilderByEmail(@RequestParam String email) {
        return builderService.getBuilderByEmail(email);
    }

    /**
   * Endpoint to create/add a builder in the database
   * @param builder Builder to add
   * @return added builder
   */
    @PostMapping("/builder")
    public Builder createBuilder(@RequestBody Builder builder) {
        return builderService.createBuilder(builder);
    }

    /**
   * Endpoint to update a builder in the database
   * @param id ID of the builder to update
   * @param updatedBuilder Builder with updated information
   * @return updated builder
   */
    @PutMapping("/builder/{id}")
    public Builder updateBuilder(@PathVariable Long id, @RequestBody Builder updatedBuilder) {
        return builderService.updateBuilder(id, updatedBuilder);
    }

    /**
   * Endpoint to delete a builder in the database
   * @param id ID of the builder to delete
   * @return list of builders in database after deletion
   */
    @DeleteMapping("/builder/{id}")
    public Object deleteBuilder(@PathVariable Long id) {
        builderService.deleteBuilder(id);
        return builderService.getAllBuilders();
    }

    /**
   * Endpoint to write builder in JSON file
   * @param builder Builder to write
   * @return success message (empty string if successful)
   */
    @PostMapping("/builder/write")
    public Object writeJson(@RequestBody Builder builder) throws IOException {
        return builderService.writeJson(builder);
    }

    /**
   * Endpoint read Builder JSON file contents
   * @return contents in JSON
   */
    @PostMapping("/builder/read")
    public Object readJson() throws IOException {
        return builderService.readJson();
    }
}