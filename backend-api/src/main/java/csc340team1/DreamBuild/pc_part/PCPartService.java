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

    /**
   * Method to get all PC parts in the database
   * @return list of PC parts in database
   */
    public List<PCPart> getAllParts() {
        return pcPartRepo.findAll();
    }

    /**
   * Method to get PC part by ID in the database
   * @param id ID of the PC part to get
   * @return PC part with the specified ID
   */
    public Object getPartById(@PathVariable long id) {
        return pcPartRepo.findById(id); 
    }

    /**
   * Method to get PC parts by part type in the database
   * @param partType Type of the PC parts to get
   * @return list of PC parts with the specified part type
   */
    public List<PCPart> getPartsByPartType(@PathVariable String partType) {
        return pcPartRepo.findByPartType(partType);
    }

    /**
   * Method to get PC parts by a builder's ID in the database
   * @param id ID of the builder to get
   * @return list of PC parts with the specified builder ID
   */
    public List<PCPart> getPartsByBuilderID(@PathVariable Long builderId) {
        return pcPartRepo.findByBuilderID(builderId);
    }

    /**
   * Method to create new PC part in the database
   * @param part PC part to create
   * @return created PC part
   */
    public PCPart createPart(PCPart part) {
        return pcPartRepo.save(part);
    }

    /**
   * Method to update PC part in the database
   * @param id ID of the PC part to update
   * @param updatedPart updated PC part information
   * @return updated PC part
   */
    public PCPart updatePart(Long id, PCPart updatedPart) {
        return pcPartRepo.findById(id).map(part -> {
            part.setName(updatedPart.getName());
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

    /**
   * Method to delete PC part in the database
   * @param id ID of the PC part to delete
   */
    public void deletePart(Long id) {
        pcPartRepo.deleteById(id);
    }

    /**
   * Method to write PC part to JSON file
   * @param part PC part to write
   */
    public String writeJson(PCPart part) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("part.json"), part);
        return "Part has been written to JSON file";
    }

    /**
   * Method to read PC part from JSON file
   * @param part PC part to read
   * @return contents in JSON
   */
    public PCPart readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("part.json"), PCPart.class);
    }
}