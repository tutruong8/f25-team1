package csc340team1.DreamBuild.pc_part;

import java.io.IOException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import csc340team1.DreamBuild.builder.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PCPartController {
    @Autowired
    private PCPartService pcPartService;
    
    @Autowired
    private BuilderService builderService;

    /**
   * Endpoint to get all pc parts in the database
   *
   * @return List of all pc parts in the database
   */
    @GetMapping("/pcpart")
    public List<PCPart> getAllParts() {
        return pcPartService.getAllParts();
    }

    /**
   * Endpoint to get the desired pc part through ID
   * @param id ID of the pc part to get
   * @return The pc part with the wanted ID
   */
    @GetMapping("/pcpart/{id}")
    public Object getPartById(@PathVariable Long id) {
        return pcPartService.getPartById(id);
    }

    /**
   * Endpoint to get pc parts through a builder's ID
   * @param builderId ID of the builder to get pc parts for
   * @return List of pc parts that belongs to the builder with the wanted ID
   */
    @GetMapping("/pcpart/builder/{builderId}")
    public List<PCPart> getPartsByBuilderID(@PathVariable Long builderId) {
        return pcPartService.getPartsByBuilderID(builderId);
    }

    /**
   * Endpoint to get pc parts through their type
   * @param type Type of the pc parts to get
   * @return List of pc parts with the wanted type
   */
    @GetMapping("/pcpart/type")
    public List<PCPart> getPartsByPartType(@RequestParam String type) {
        return pcPartService.getPartsByPartType(type);
    }


    @GetMapping("/pcpart/new")
    public Object newPartForm(Model model) {
        PCPart part = new PCPart();
        model.addAttribute("part", part);
        model.addAttribute("partTypes", PCPartType.values());
        model.addAttribute("title", "Add New PC Part");
        return "builder/builderNewPart";
    }
    /**
   * Endpoint to create/add a PC part in the database
   * @param part PC part to add
   * @return added PC part
   */
    @PostMapping("/pcpart")
    public Object createPart(@RequestParam Long builderId, PCPart part) {
        Builder builder = builderService.getBuilderById(builderId);
        part.setBuilder(builder);

        pcPartService.createPart(part);

        return "redirect:/builder/" + builderId + "/services";
    }

    /**
   * Endpoint to update a PC part in the database
   * @param id ID of the PC part to update
   * @param part PC part with updated information
   * @return updated PC part
   */
    @PutMapping("/pcpart/{id}")
    public Object updatePart(@PathVariable Long id, @RequestBody PCPart part) {
        return pcPartService.updatePart(id, part);
    }

    /**
   * Endpoint to delete a PC part in the database
   * @param id ID of the PC part to delete
   * @return list of PC parts in database after deletion
   */
    @DeleteMapping("/pcpart/{id}")
    public void deletePart(@PathVariable Long id) {
        pcPartService.deletePart(id);
    }

    /**
   * Endpoint to write PC part in JSON file
   * @param part PC part to write
   * @return success message (empty string if successful)
   */
    @PostMapping("/pcpart/write")
    public Object writeJson(@RequestBody PCPart part) throws IOException {
        return pcPartService.writeJson(part);
    }

    /**
   * Endpoint read PC part JSON file contents
   * @return contents in JSON
   */
    @PostMapping("/pcpart/read")
    public Object readJson() throws IOException {
        return pcPartService.readJson();
    }
}