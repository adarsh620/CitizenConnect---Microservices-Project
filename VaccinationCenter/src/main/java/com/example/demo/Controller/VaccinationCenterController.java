package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.RequiredResponse;
import com.example.demo.Repo.VaccinationCenterRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import com.example.demo.Entity.VaccinationCenter;
import com.example.demo.Model.Citizen;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/vaccination-center")
public class VaccinationCenterController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private VaccinationCenterRepository vaccinationRepo;
    
    @PostMapping(path ="/add")
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vaccinationCenter) {
		
		VaccinationCenter vaccinationCenterAdded = vaccinationRepo.save(vaccinationCenter);
		return new ResponseEntity<>(vaccinationCenterAdded, HttpStatus.OK);
	}
	

    @GetMapping(path = "/id/{id}")
//    @HystrixCommand(fallbackMethod = "fallbackMethodCitizenService")
    @CircuitBreaker(name = "fallback method", fallbackMethod="fallbackMethodCitizenService")
    public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(@PathVariable Integer id) {
        // Fetch vaccination center details
        VaccinationCenter center = vaccinationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaccination Center not found"));

        // Fetch list of citizens using RestTemplate
        // Servcie Name should be same as it is registered on Eureka Server . YML me CITIZEN-SERVICE" but Eureka dashboard me "CITIZENSERVICE".
        // we will use name of Eureka Dashboard only .
        List<Citizen> citizens = restTemplate.getForObject("http://CITIZENSERVICE/citizen/id/" + id, List.class); 

        // Prepare response
        RequiredResponse response = new RequiredResponse(center, citizens);
        return ResponseEntity.ok(response);
    }
    
 // Fallback method when citizen service is down
    public ResponseEntity<RequiredResponse> fallbackMethodCitizenService(@PathVariable Integer id, Throwable throwable) {
        VaccinationCenter center = vaccinationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaccination Center not found"));

        // Return default response when Citizen Service is unavailable
        String errorMessage = "Citizen Service is unavailable. Please try later.";
        RequiredResponse response = new RequiredResponse(center, errorMessage);
        return ResponseEntity.ok(response);
    }
    
    
    
    

}
