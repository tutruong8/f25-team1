package csc340team1.DreamBuild.computerbuild;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import csc340team1.DreamBuild.customer.Customer;
import csc340team1.DreamBuild.customer.CustomerRepo;
import csc340team1.DreamBuild.pc_part.PCPart;
import csc340team1.DreamBuild.pc_part.PCPartRepo;

@Controller
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @Autowired
    private PCPartRepo pcPartRepo;

    @Autowired
    private CustomerRepo customerRepo;


    // ------------------------------
    // BASIC CRUD ENDPOINTS
    // ------------------------------

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


   

    @PostMapping("/computer/write")
    public Object writeJson(@RequestBody Computer computer) throws IOException {
        return computerService.writeJson(computer);
    }

    @PostMapping("/computer/read")
    public Object readJson() throws IOException {
        return computerService.readJson();
    }

}