package fr.formation.developers.Domain;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;

//là c'est une portion du "developer", juste pour modif la date de naissance.
//on utilise les verbes dans le nomage : Patch, Delete, etc., même si c'est mieux qu'on ne fait pas comme ça,
//donc au début on nommait cette classe DeveloperPatch, là on a changé en DeveloperUpdate :
// la classe represente un input qui est date de naissance
public class DeveloperUpdate {

    @NotNull
    private LocalDate birthDate ;

    public DeveloperUpdate(){

    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public void setBirthDate (LocalDate birthDate){
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "DeveloperUpdate [birthDate=" + birthDate + "]";
    }

}
