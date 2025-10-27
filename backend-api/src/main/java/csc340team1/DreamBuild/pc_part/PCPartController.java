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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PCPartController {
    @Autowired
    private PCPartService pcPartService;
    @GetMapping("/pcpart")
    public List<PCPart> getAllParts() {
        return pcPartService.getAllParts();
    }

    @GetMapping("/pcpart/{id}")
    public Object getPartById(@PathVariable Long id) {
        return pcPartService.getPartById(id);
    }

    @GetMapping("/pcpart/builder/{builderId}")
    public List<PCPart> getPartsByBuilderID(@PathVariable Long builderId) {
        return pcPartService.getPartsByBuilderID(builderId);
    }

    @GetMapping("/pcpart/type")
    public List<PCPart> getPartsByPartType(@RequestParam String type) {
        return pcPartService.getPartsByPartType(type);
    }

    @PostMapping("/pcpart")
    public PCPart createPart(@RequestBody PCPart part) {
        return pcPartService.createPart(part);
    }

    @PutMapping("/pcpart/{id}")
    public PCPart updatePart(@PathVariable Long id, @RequestBody PCPart part) {
        return pcPartService.updatePart(id, part);
    }

    @DeleteMapping("/pcpart/{id}")
    public void deletePart(@PathVariable Long id) {
        pcPartService.deletePart(id);
    }

    @PostMapping("/pcpart/write")
    public Object writeJson(@RequestBody PCPart part) throws IOException {
        return pcPartService.writeJson(part);
    }

    @PostMapping("/pcpart/read")
    public Object readJson() throws IOException {
        return pcPartService.readJson();
    }
}
