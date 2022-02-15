package com.saude.itabaianinha.vacina.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Vaccine {

    private String cns; // Posição 0
    private String name; // Posição 1
    private String cpf; // Posição 2
    private String sex; // Posição 3
    private String birthDate; //Posição 9
    private String category; // Posição 25
    private String vaccineDateApplication; // Posição 27
    private String doseNumber; // Posição 28
    private String manufacturer; // Posição 29
    private String group; //Posição 31
    private String allotment; // Posição 32
    private String VaccineName; // Posição 33
    private String applicatorName; // Posição 37

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccine vaccine = (Vaccine) o;
        return Objects.equals(cns, vaccine.cns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cns);
    }
}
