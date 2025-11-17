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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class BuilderController {
    @Autowired
    private BuilderService builderService;

    /**
   * Endpoint to get all builders in the database
   *
   * @return List of all builders in the database
   */
    @GetMapping("/builder")
    public String getAllBuilders(Model model) {
        model.addAttribute("builders", builderService.getAllBuilders());
        model.addAttribute("title", "Builders");
        return "builder-list";
    }

    /**
   * Endpoint to get the desired builder through ID
   * @param id ID of the builder to get
   * @return The builder with the wanted ID
   */
    @GetMapping("/builder/{id}")
    public Object getBuilderById(@PathVariable long id, Model model) {
        model.addAttribute("builder", builderService.getBuilderById(id));
        model.addAttribute("title", "Builder Details");
        return "builder/builderProfile";
    }

    /**
   * Endpoint to get the desired builder through email
   * @param email Email of the builder to get
   * @return The builder with the wanted email
   */
    @GetMapping("/builder/email")
    public Object getBuilderByEmail(@RequestParam String email, Model model) {
        model.addAttribute("builder", builderService.getBuilderByEmail(email));
        model.addAttribute("title", "Builder Details");
        return "builder-detail";
    }


    @GetMapping("/builder/new")
    public Object builderSignUp(Model model){
        Builder newBuilder = new Builder();
        model.addAttribute("builder", newBuilder);
        model.addAttribute("title", "Sign Up Builder");
        return "ProviderSignUp";
    }
    /**
   * Endpoint to create/add a builder in the database
   * @param builder Builder to add
   * @return added builder
   */
    @PostMapping("/builder")
    public Object createBuilder(Builder builder) {
        Builder newBuilder = builderService.createBuilder(builder);
        return "redirect:/builder/" + newBuilder.getId();
    }


    @GetMapping("/builder/update/{id}")
    public Object updateBuilderForm(@PathVariable Long id, Model model){
        model.addAttribute("builder", builderService.getBuilderById(id));
        model.addAttribute("title", "Update Builder: " + id);
        return "builder/builderProfile";
    }

    /**
   * Endpoint to update a builder in the database
   * @param id ID of the builder to update
   * @param updatedBuilder Builder with updated information
   * @return updated builder
   */
    @PostMapping("/builder/{id}")
    public Object updateBuilder(@PathVariable Long id, Builder builder) {
        builderService.updateBuilder(id, builder);
        return "redirect:/builder/" + id;
    }

    /**
   * Endpoint to delete a builder in the database
   * @param id ID of the builder to delete
   * @return list of builders in database after deletion
   */
    @GetMapping("/builder/delete/{id}")
    public Object deleteBuilder(@PathVariable Long id) {
        builderService.deleteBuilder(id);
        return "redirect:/builder";
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