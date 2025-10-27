package csc340team1.DreamBuild.pc_part;
import java.util.*;
import java.io.IOException;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class PCPartService {
   @Autowired
    private PCPartRepo pcPartRepo;

    public List<PCPart> getAllParts() {
        return pcPartRepo.findAll();
    }
    public Object getPartById(@PathVariable long id) {
        return pcPartRepo.findById(id); 
    }

    public List<PCPart> getPartsByPartType(@PathVariable String partType) {
        return pcPartRepo.findByPartType(partType);
    }

    public List<PCPart> getPartsByBuilderID(@PathVariable Long builderId) {
        return pcPartRepo.findByBuilderID(builderId);
    }

    public PCPart createPart(PCPart part) {
        return pcPartRepo.save(part);
    }

    public PCPart updatePart(Long id, PCPart updatedPart) {
        return pcPartRepo.findById(id).map(part -> {
            part.setDescription(updatedPart.getDescription ());
            part.setPartType(updatedPart.getPartType());
            part.setPrice(updatedPart.getPrice());
            part.setQuantity(updatedPart.getQuantity());
            part.setBuilder(updatedPart.getBuilder());
            return pcPartRepo.save(part);
        }).orElseGet(() -> {
            updatedPart.setId(id);
            return pcPartRepo.save(updatedPart);
        });
    }

    public void deletePart(Long id) {
        pcPartRepo.deleteById(id);
    }

    public String writeJson(PCPart part) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("part.json"), part);
        return "Part has been written to JSON file";
    }

    public PCPart readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("part.json"), PCPart.class);
    }
}