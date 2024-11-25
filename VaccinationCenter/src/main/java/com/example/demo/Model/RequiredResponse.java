package com.example.demo.Model;

import java.util.List;
import com.example.demo.Entity.VaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {

    private VaccinationCenter vaccinationCenter;
    private List<Citizen> citizens;
    private String message; // New field for the message

    // Constructor for normal response (with citizens list)
    public RequiredResponse(VaccinationCenter vaccinationCenter, List<Citizen> citizens) {
        this.vaccinationCenter = vaccinationCenter;
        this.citizens = citizens;
    }

    // Constructor for fallback response (with a message)
    public RequiredResponse(VaccinationCenter vaccinationCenter, String message) {
        this.vaccinationCenter = vaccinationCenter;
        this.citizens = null; // No citizens in the fallback response
        this.message = message; // Set the custom error message
    }
}
