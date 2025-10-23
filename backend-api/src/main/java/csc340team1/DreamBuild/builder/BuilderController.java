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

    @GetMapping("/builders")
    public List<Builder> getAllBuilders() {
        return builderService.getAllBuilders();
    }

    @GetMapping("/builders/{id}")
    public Object getBuilderById(@PathVariable long id) {
        return builderService.getBuilderById(id);
    }

    @GetMapping("/builders/name")
    public Object getBuilderByName(@RequestParam String name) {
        return builderService.getBuilderByName(name);
    }

    @GetMapping("/builders/email")
    public Object getBuilderByEmail(@RequestParam String email) {
        return builderService.getBuilderByEmail(email);
    }

    @GetMapping("/builders/address")
    public Object getBuilderByAddress(@RequestParam String address) {
        return builderService.getBuilderByAddress(address);
    }

    @PostMapping("/builders")
    public Builder createBuilder(@RequestBody Builder builder) {
        return builderService.createBuilder(builder);
    }

    @PutMapping("/builders/{id}")
    public Builder updateBuilder(@PathVariable Long id, @RequestBody Builder updatedBuilder) {
        return builderService.updateBuilder(id, updatedBuilder);
    }

    @DeleteMapping("/builders/{id}")
    public Object deleteBuilder(@PathVariable Long id) {
        builderService.deleteBuilder(id);
        return builderService.getAllBuilders();
    }

    @PostMapping("/animal/write")
    public Object writeJson(@RequestBody Builder builder) throws IOException {
        return builderService.writeJson(builder);
    }

    @PostMapping("/animal/read")
    public Object readJson() throws IOException {
        return builderService.readJson();
    }
}