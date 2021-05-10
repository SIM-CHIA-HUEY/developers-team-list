package fr.formation.developers.Domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;



@Entity
public class TeamCreate {
    @NotBlank(message = "Team name is mandatory")
    private String teamName;
    private boolean agile ;

    public TeamCreate (){
    }

    // Team name
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    // Agile ? (boolean)
    public boolean isAgile() { return agile; }
    public void setAgile(boolean agile) { this.agile = agile; }

    // RESULT 1

    public String toString(){
        return "Team [Name: " + teamName + " ; Is it team agile ? :" + agile + "]";
    }
    //public TeamCreate deleteByTeamName (TeamCreate team){
      //  return null;
    //}
}
