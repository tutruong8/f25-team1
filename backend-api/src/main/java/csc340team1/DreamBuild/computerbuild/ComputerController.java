
package csc340team1.DreamBuild.computerbuild;

import java.io.IOException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComputerController {
    @Autowired
    private ComputerService computerService;

    /**
   * Endpoint to get all computers in the database
   *
   * @return List of all computers in the database
   */
    @GetMapping("/computer")
    public List<Computer> getAllComputers() {
        return computerService.getAllComputers();
    }

    /**
   * Endpoint to get the desired computer through ID
   * @param id ID of the computer to get
   * @return The computer with the wanted ID
   */
    @GetMapping("/computer/{id}")
    public Object getComputerById(@PathVariable long id) {
        return computerService.getComputerById(id);
    }

    /**
   * Endpoint to get the desired computer through a builder's ID
   * @param builderId ID of the builder to get
   * @return The computers with the wanted builder ID
   */
    @GetMapping("/computer/builder/{builderId}")
    public List<Computer> getComputersByBuilderID(@PathVariable Long builderId) {
        return computerService.getComputersByBuilderID(builderId);
    }

    /**
   * Endpoint to create/add a computer in the database
   * @param computer Computer to add
   * @return added computer
   */
    @PostMapping("/computer")
    public Computer createComputer(@RequestBody Computer computer) {
        return computerService.createComputer(computer);
    }

    /**
   * Endpoint to update a computer in the database
   * @param id ID of the computer to update
   * @param computer Computer with updated information
   * @return updated computer
   */
    @PutMapping("/computer/{id}")
    public Computer updateComputer(@PathVariable Long id, @RequestBody Computer updatedComputer) {
        return computerService.updateComputer(id, updatedComputer);
    }

    /**
   * Endpoint to delete a computer in the database
   * @param id ID of the computer to delete
   * @return list of computers in database after deletion
   */
    @DeleteMapping("/computer/{id}")
    public void deleteComputer(@PathVariable Long id) {
        computerService.deleteComputer(id);
    }

    /**
   * Endpoint to write computer in JSON file
   * @param computer Computer to write
   * @return success message (empty string if successful)
   */
    @PostMapping("/computer/write")
    public Object writeJson(@RequestBody Computer computer) throws IOException {
        return computerService.writeJson(computer);
    }

    /**
   * Endpoint read Computer JSON file contents
   * @return contents in JSON
   */
    @PostMapping("/computer/read")
    public Object readJson() throws IOException {
        return computerService.readJson();
    }
}
