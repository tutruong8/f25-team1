package csc340team1.DreamBuild.computerbuild;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import csc340team1.DreamBuild.customer.Customer;
import csc340team1.DreamBuild.customer.CustomerRepo;
import csc340team1.DreamBuild.pc_part.PCPart;
import csc340team1.DreamBuild.pc_part.PCPartRepo;

@RestController
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


    // ------------------------------
    // SAVE BUILD (FROM BUILDER PAGE)
    // ------------------------------

    @PostMapping("/computer/save-build")
    @ResponseBody
    public String saveBuild(
            @RequestParam Long customerId,
            @RequestParam String description,
            @RequestParam BigDecimal price,
            @RequestParam Long cpuId,
            @RequestParam Long gpuId,
            @RequestParam Long moboId,
            @RequestParam Long caseId,
            @RequestParam(required = false) Long fanId
    ) {

        PCPart cpu = pcPartRepo.findById(cpuId).orElse(null);
        PCPart gpu = pcPartRepo.findById(gpuId).orElse(null);
        PCPart mobo = pcPartRepo.findById(moboId).orElse(null);
        PCPart pcCase = pcPartRepo.findById(caseId).orElse(null);
        PCPart fan = (fanId != null) ? pcPartRepo.findById(fanId).orElse(null) : null;

        Customer customer = customerRepo.findById(customerId).orElse(null);

        Computer build = new Computer(description, price, 1, null, customer, cpu, gpu, mobo, pcCase, fan);

        build.setCreatedAt(LocalDateTime.now());

        computerService.createComputer(build);

        return "Build saved successfully!";
    }

}
