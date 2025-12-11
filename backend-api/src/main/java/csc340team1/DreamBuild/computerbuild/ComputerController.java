package csc340team1.DreamBuild.computerbuild;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotati

import csc340team1.DreamBuild.customer.CustomerRepo;
import csc340team1.DreamBuild.pc_part.PCPartRepo;

import csc340team1.DreamBuild.customer.CustomerRepo;
import csc340team1.DreamBuild.pc_part.PCPartRepo;on.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

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
