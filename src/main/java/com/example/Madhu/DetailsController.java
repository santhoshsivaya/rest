package com.example.Madhu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/details")
public class DetailsController {
    @Autowired
    public DetailsRepository repository;
    @GetMapping
    public List<Details> getAllDetails(){
        return repository.findAll();
    }
    @PostMapping
    public String saveDetails(@RequestBody Details details){
        repository.save(details);
        return "Detials saved sucessfully...";
    }
    @PostMapping("/bulkDetails")
    public String saveDetails(@RequestBody List <Details> details){
        repository.saveAll(details);
        return "All details saved sucessfully...";

    }
    @GetMapping("/{id}")
    public Optional<Details> getById(@PathVariable long id ){
        return repository.findById(id);
    }
    @PutMapping
    public String updateDetails(@RequestBody Details details){
        Optional<Details> exist= repository.findById(details.getId());
        if(exist.isPresent()){
            repository.save(details);
            return "Details updated sucessfully...";
        }
        return "Detail isn't updated... ";

    }
    @DeleteMapping("/{id}")
    public String deleteDetails(@PathVariable long id){
        repository.deleteById(id);
        return "Details deleted successfully...";
    }

}
