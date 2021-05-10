package fr.formation.developers.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.developers.Domain.DeveloperUpdate;
import fr.formation.developers.Domain.DeveloperCreate;

import javax.validation.Valid;

@RestController
/*
 * @RequestMapping permet d'indiquer le segment de la collection de ressources
 * une seule fois pour la classe au lieu de le répéter à chaque mapping. Spring,
 * au démarrage, concatène le nom de la collection avec tous les mappings
 * déclarés dans le controller. Ex. : "/developers" + "/{pseudo}" =>
 * "/developers/{pseudo}"
 */
@RequestMapping("/developers")

public class DeveloperController {

    @GetMapping("/{pseudo}")
    public DeveloperCreate getByPseudo(@PathVariable("pseudo") String pseudo) {
        DeveloperCreate developer = new DeveloperCreate();
        developer.setPseudo(pseudo); //pseudo ici tu écris ce que tu veux dans URL à la place de {pseudo}, et apparaîtra comme écrit dans Postman
        developer.setFirstName("Frank");
        developer.setLastName("MARSHALL");
        LocalDate date = LocalDate.of(1974, 12, 26);
        developer.setBirthDate(date);
        System.out.println(developer);
        return developer;
    }

    // Parenthèses optionnelles si pas de paramètres à une annotation
    @PostMapping
    public void create(@RequestBody DeveloperCreate developer) {
        System.out.println(developer);
    }

    /**
     * Modifie partiellement une ressource de type "Developer", ici uniquement
     * la date de naissance, le développeur est identifié par son pseudo.
     * <p>
     * On utilise le verbe "PATCH" pour la modification partielle d'une
     * ressource. Comme pour un "get by id", la pratique est d'utiliser une
     * variable de chemin avec l'identifiant de ressource, ici le pseudo.
     * <p>
     * Dans le cas présent on ne modifie qu'une seule donnée sur le développeur
     * (la date de naissance) mais bien entendu on peut avoir à modifier
     * plusieurs données sur une même ressource. La pratique est d'envoyer un
     * JSON dans le corps de la requête HTTP, tout comme pour une création de
     * ressource ("POST").
     * <p>
     * Il est assez fréquent d'avoir plusieurs "PATCH" sur un même type de
     * ressource, le couple verbe + url devant être unique il faut un moyen de
     * lever toute ambiguité, on peut utiliser un verbe ou un nom dans l'url
     * indiquant au client de l'API ce qui est modifié.
     *
     * @param pseudo le pseudo identifiant une ressource "Developer"
     * @param partial les données partielles d'une ressource "Developer"
     */
    // method rien a voir avec les autres
    @PatchMapping("/{nom}/birth-date")
    //dans les () du dessous c'est les arguments, là y'en a 2 et c'est ce que le framework va exécuter quand lancé
    public void updateBirthDate(@PathVariable("nom") String pseudo, //le pseudo (JAVA)/nom(url) lié à @PathVariable, vient pas d'une classe ou autre, mais de PatchMapping ici.
                                @Valid  @RequestBody DeveloperUpdate partial) {
        // @Valid : avant ligne 83 (avant d'exécuter la méthode), pour verif si le input est valide pr garantir que les données soient cohérentes dans l'application
        // @RequestBody : attend le body dans Postman. Object JAVA <-> JSON. Faut donc entrer les données dans Postman (ss format JSON, car c'est ce qu'on utilise)
        // pour qu'on le voit dans la console ici.

       // System.out.println("Partial object=" + partial);
       // DeveloperCreate developer = new DeveloperCreate();
       // developer.setPseudo(pseudo); // Variable de chemin
       // developer.setFirstName(partial.getFirstName()); // Anomalie
       // developer.setLastName("MARSHALL");
       // developer.setBirthDate(partial.getBirthDate()); // JSON
       // System.out.println("New object=" + developer);

        System.out.println("Update birth date of:" + pseudo +
                " with new date :" + partial.getBirthDate());
    }

}

// Dans un controller on peut avoir plusieurs Request/Post/Patch(verbes) Mapping(contrat),
// il faut juste que les url soient différents = URL unique pour chaque endpoint
// et chaque endpoint = classe (classe des input)

// BUT des annotations Spring : VB + URL -> pour que le framework sache quelle méthode du JAVA exécuter
