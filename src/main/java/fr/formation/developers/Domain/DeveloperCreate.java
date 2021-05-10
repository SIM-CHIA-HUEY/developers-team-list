package fr.formation.developers.Domain;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class DeveloperCreate {

    @NotNull
    private String pseudo;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    public DeveloperCreate() {
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Developer [pseudo=" + pseudo + ", firstName=" + firstName
                + ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
    }
}
