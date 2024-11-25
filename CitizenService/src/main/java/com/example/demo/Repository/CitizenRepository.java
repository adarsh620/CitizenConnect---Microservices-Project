package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
	
	
	/**
     * Derived query method to fetch all citizens associated with a specific vaccination center.
     * Spring Data JPA will automatically create the corresponding SQL query based on the method name.
     * 
     * Query generated: SELECT * FROM citizen WHERE vaccination_center_id = :id
     * 
     * @param id The ID of the vaccination center.
     * @return A list of citizens associated with the given vaccination center.
     */	
   public List<Citizen> findByVaccinationCenterId(Integer id);
	
}
