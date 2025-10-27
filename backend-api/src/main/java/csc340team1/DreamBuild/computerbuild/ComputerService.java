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

    public List<Computer> getAllComputers() {
        return computerRepo.findAll();
    }
    public Object getComputerById(@PathVariable long id) {
        return computerRepo.findById(id); 
    }

    public List<Computer> getComputersByBuilderID(@PathVariable Long builderId) {
        return computerRepo.findByBuilderID(builderId);
    }

    public Computer createComputer(Computer computer) {
        return computerRepo.save(computer);
    }

    public Computer updateComputer(Long id, Computer updatedComputer) {
        return computerRepo.findById(id).map(computer -> {
            computer.setDescription(updatedComputer.getDescription());
            computer.setPrebuilt(updatedComputer.isPrebuilt());
            computer.setPrice(updatedComputer.getPrice());
            computer.setQuantity(updatedComputer.getQuantity());
            computer.setBuilder(updatedComputer.getBuilder());
            computer.setCpu(updatedComputer.getCpu());
            computer.setGpu(updatedComputer.getGpu());
            computer.setMobo(updatedComputer.getMobo());
            computer.setPcCase(updatedComputer.getPcCase());
            computer.setFan(updatedComputer.getFan());
            return computerRepo.save(computer);
        }).orElseGet(() -> {
            updatedComputer.setId(id);
            return computerRepo.save(updatedComputer);
        });
    }

    public void deleteComputer(Long id) {
        computerRepo.deleteById(id);
    } 
}
