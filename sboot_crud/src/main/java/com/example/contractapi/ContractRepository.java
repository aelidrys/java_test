package com.example.contractapi;

import org.springframework.data.jpa.repository.JpaRepository;

interface ContractRepository extends JpaRepository<Contract, Long> {

}
