package csc340team1.DreamBuild.computerbuild;

import java.util.*;
import java.io.IOException;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class ComputerService {
   @Autowired
    private ComputerRepo computerRepo;

    /**
   * Method to get all computers in the database
   * @return list of computers in database
   */
    public List<Computer> getAllComputers() {
        return computerRepo.findAll();
    }

    /**
   * Method to get computer by ID in the database
   * @param id ID of the computer to get
   * @return computer with the specified ID
   */
    public Object getComputerById(@PathVariable long id) {
        return computerRepo.findById(id); 
    }

    /**
   * Method to get computers by a builder's ID in the database
   * @param id ID of the builder to get
   * @return list of computers with the specified builder ID
   */
    public List<Computer> getComputersByBuilderID(@PathVariable Long builderId) {
        return computerRepo.findByBuilderID(builderId);
    }

    /**
   * Method to create new computer in the database
   * @param computer Computer to create
   * @return created computer
   */
    public Computer createComputer(Computer computer) {
        return computerRepo.save(computer);
    }

    /**
   * Method to update computer in the database
   * @param id ID of the computer to update
   * @param updatedComputer updated computer information
   * @return updated computer
   */
    public Computer updateComputer(Long id, Computer updatedComputer) {
        return computerRepo.findById(id).map(computer -> {
            computer.setImageURL(updatedComputer.getImageURL());
            computer.setName(updatedComputer.getName());
            computer.setDescription(updatedComputer.getDescription());
            computer.setPrebuilt(updatedComputer.isPrebuilt());
            computer.setPrice(updatedComputer.getPrice());
            computer.setQuantity(updatedComputer.getQuantity());
            computer.setBuilder(updatedComputer.getBuilder());
            computer.setCustomer(updatedComputer.getCustomer());
            computer.setReview(updatedComputer.getReview());
            computer.setCpu(updatedComputer.getCpu());
            computer.setGpu(updatedComputer.getGpu());
            computer.setRam(updatedComputer.getRam());
            computer.setStorage(updatedComputer.getStorage());
            computer.setMobo(updatedComputer.getMobo());
            computer.setPcCase(updatedComputer.getPcCase());
            computer.setFan(updatedComputer.getFan());
            computer.setCooler(updatedComputer.getCooler());
            computer.setPsu(updatedComputer.getPsu());
            return computerRepo.save(computer);
        }).orElseGet(() -> {
            updatedComputer.setId(id);
            return computerRepo.save(updatedComputer);
        });
    }

    /**
   * Method to delete computer in the database
   * @param id ID of the computer to delete
   */
    public void deleteComputer(Long id) {
        computerRepo.deleteById(id);
    } 

    /**
   * Method to write builder to JSON file
   * @param computer Computer to write
   */
    public String writeJson(Computer computer) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("computer.json"), computer);
        return "Computer has been written to JSON file";
    }

    /**
   * Method to read computer in the database
   * @param computer Computer to read
   * @return contents in JSON
   */
    public Computer readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("computer.json"), Computer.class);
    }
}
