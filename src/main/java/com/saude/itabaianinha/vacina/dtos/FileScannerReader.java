package com.saude.itabaianinha.vacina.dtos;

import lombok.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@Data
/**
 * @author Rai Rafael
 * @contact
 */
public class FileScannerReader {
    Scanner vaccineReader;
    Scanner teamReader;

    public FileScannerReader() throws FileNotFoundException {
        vaccineReader = new Scanner(new FileReader("C:/Users/ESUSPEC/Documents/Raí Rafael/Dev/Java/projects/vacina/files/vacina.csv"));
        teamReader = new Scanner(new FileReader("C:/Users/ESUSPEC/Documents/Raí Rafael/Dev/Java/projects/vacina/files/equipe.csv"));
    }


}
