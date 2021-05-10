package fr.formation.developers;

// provient des packagings de Springboot (répertoire.sous répertoire.sous répertoire)
// les annotations là c'est pour dire : une méga classe de Springboot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevelopersApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevelopersApplication.class, args);
        //Jusque là on touche jamais à ce code au dessus
        // ça va run DevelopersApplication = cette application
    }

}

