package csc340team1.DreamBuild.computerbuild;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComputerController {
    @Autowired
    private ComputerService computerService;

    @GetMapping("/computer")
    public List<Computer> getAllComputers() {
        return computerService.getAllComputers();
    }

    @GetMapping("/computer/{id}")
    public Object getComputerById(@PathVariable long id) {
        return computerService.getComputerById(id);
    }

    @GetMapping("/computer/builder/{builderId}")
    public List<Computer> getComputersByBuilderID(@PathVariable Long builderId) {
        return computerService.getComputersByBuilderID(builderId);
    }

    @PostMapping("/computer")
    public Computer createComputer(@RequestBody Computer computer) {
        return computerService.createComputer(computer);
    }

    @PutMapping("/computer/{id}")
    public Computer updateComputer(@PathVariable Long id, @RequestBody Computer updatedComputer) {
        return computerService.updateComputer(id, updatedComputer);
    }

    @DeleteMapping("/computer/{id}")
    public void deleteComputer(@PathVariable Long id) {
        computerService.deleteComputer(id);
    }
}
