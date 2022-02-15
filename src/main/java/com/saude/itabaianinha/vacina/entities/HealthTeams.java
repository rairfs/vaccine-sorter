package com.saude.itabaianinha.vacina.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class HealthTeams {
    private String name; // Posição 0
    private String cpf; // Posição 1
    private String cns; // Posição 2
    private String birthDate; // Posição 3
    private final String teamName = "SESP";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthTeams that = (HealthTeams) o;
        return Objects.equals(cns, that.cns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cns);
    }
}
