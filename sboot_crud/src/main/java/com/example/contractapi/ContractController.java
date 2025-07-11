package com.example.contractapi;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
class ContractController {

  private final ContractRepository repository;

  ContractController(ContractRepository repository) {
    this.repository = repository;
  }


  // list all contracts
  @GetMapping("/contracts")
  List<Contract> all() {
    return repository.findAll();
  }
  
  // add new contract
  @PostMapping("/contracts")
  Contract newContract(@RequestBody Contract newContract) {
    return repository.save(newContract);
  }


  // get one contract by id
  @GetMapping("/contracts/{id}")
  EntityModel<Contract> one(@PathVariable Long id) {
    
    Contract contract =  repository.findById(id)
      .orElseThrow(() -> new ContractNotFoundException(id));

    return EntityModel.of(contract, //
      linkTo(methodOn(ContractController.class).one(id)).withSelfRel(),
      linkTo(methodOn(ContractController.class).all()).withRel("contract"));
  }

  // update a contract by id
  @PutMapping("/contracts/{id}")
  Contract replaceContract(@RequestBody Contract newContract, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(Contract -> {
        Contract.setTitle(newContract.getTitle());
        Contract.setClientName(newContract.getClientName());
        Contract.setStartDate(newContract.getStartDate());
        Contract.setEndDate(newContract.getEndDate());
        // Contract.setStatus(newContract.getEStatus());
        return repository.save(Contract);
      })
      .orElseGet(() -> {
        return repository.save(newContract);
      });
  }

  // delete a contract by id
  @DeleteMapping("/contracts/{id}")
  void deleteContract(@PathVariable Long id) {
    repository.deleteById(id);
  }
}