package com.saude.itabaianinha.vacina.services;

import com.saude.itabaianinha.vacina.dtos.FileScannerReader;
import com.saude.itabaianinha.vacina.entities.HealthTeams;
import com.saude.itabaianinha.vacina.entities.Vaccine;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VacinaService {
    private final FileScannerReader FILESCANNERREADER;

    private int countFileVaccine;
    private int countFileTeamHealth;
    private Vaccine vaccine;
    private HealthTeams healthTeams;
    private String teamName;
    private List<Vaccine> vaccineList;
    private List<HealthTeams> healthTeamsList;
    private BufferedWriter br;

    public VacinaService(String teamName) throws FileNotFoundException {
        this.vaccineList = new ArrayList<>();
        this.healthTeamsList = new ArrayList<>();
        this.countFileVaccine = 0;
        this.countFileTeamHealth = 0;
        this.teamName = teamName;
        this.FILESCANNERREADER = new FileScannerReader();
    }

    public void combineAndShow() throws IOException {
        insertVaccineData();
        insertHealthTeamData();
        br = new BufferedWriter(new FileWriter("C:/Users/ESUSPEC/Documents/Raí Rafael/Dev/Java/projects/vacina/files/final.csv"));
        for (HealthTeams hList : healthTeamsList){
            for (Vaccine vList : vaccineList){
                if (hList.getCns().equals(vList.getCns())){
                    br.write(vList.getCns()+";"+vList.getName()+";"+vList.getCpf()+";"+vList.getSex()+";"+vList.getBirthDate()+";"+vList.getCategory()+";"+vList.getVaccineDateApplication()+";"+vList.getDoseNumber()+";"+vList.getManufacturer()+";"+vList.getGroup()+";"+vList.getAllotment()+";"+vList.getVaccineName()+";"+vList.getApplicatorName()+";"+teamName);
                    br.newLine();
                }
            }
        }
    }

    private void insertVaccineData(){
        while (FILESCANNERREADER.getVaccineReader().hasNext()){
            if (countFileVaccine == 0){
                countFileVaccine++;
                FILESCANNERREADER.getVaccineReader().nextLine();
                continue;
            }
            String fileVaccine = FILESCANNERREADER.getVaccineReader().nextLine();
            String[] arrayFileVaccine = fileVaccine.split(";");
            vaccine = new Vaccine(arrayFileVaccine[0], arrayFileVaccine[1], arrayFileVaccine[2], arrayFileVaccine[3]
                    , arrayFileVaccine[9], arrayFileVaccine[25], arrayFileVaccine[27], arrayFileVaccine[28], arrayFileVaccine[29]
                    , arrayFileVaccine[31], arrayFileVaccine[32], arrayFileVaccine[33], arrayFileVaccine[37]);
            vaccineList.add(vaccine);

        }
    }

    private void insertHealthTeamData(){
        while (FILESCANNERREADER.getTeamReader().hasNext()){
            if (countFileTeamHealth < 12){
                countFileTeamHealth++;
                FILESCANNERREADER.getTeamReader().nextLine();
                continue;
            }
            String fileVaccine = FILESCANNERREADER.getTeamReader().nextLine();
            String[] arrayFileHealthTeam = fileVaccine.split(";");
            healthTeams = new HealthTeams(arrayFileHealthTeam[0], arrayFileHealthTeam[1], arrayFileHealthTeam[2], arrayFileHealthTeam[3]);
            healthTeamsList.add(healthTeams);
        }
    }


}
