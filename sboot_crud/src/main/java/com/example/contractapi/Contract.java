package com.example.contractapi;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Id;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;

@Entity
@Table(name = "contract")
public class Contract{
    
    private @Id @GeneratedValue Long id;
    @NotBlank(message = "title is mandatory")
    private String title;
    @NotBlank(message = "clientName is mandatory")
    private String clientName;
    private LocalDate startDate;
    private LocalDate endDate;
    // private Enum status;

    public Contract(String title, String clientName, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.clientName = clientName;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Contract(){}
    public Contract(String title, String clientName) {
        this.title = title;
        this.clientName = clientName;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // public Enum getStatus() {
    //     return status;
    // }
    // public void setStatus(Enum status) {
    //     this.status = status;
    // }

    


   
}