package fr.formation.developers.Domain;

        import javax.validation.constraints.NotNull;

/**
 * Classe qui représente une compétence simple avec son nom.
 * <p>
 * Elle respecte les conventions de nommage dites "Javabeans" qui sont très
 * importantes à respecter dans bien des cas, car Spring et ses dépendances
 * s'appuient dessus notamment pour réaliser les mappings (par ex. JSON => objet
 * Java et inversement).
 */
public class Skill {

    @NotNull
    private String name; // Variable d'instance private
    // Construit un nouvel objet (instance) de type "Skill".

    /**
     * Construit un nouvel objet (instance) de type "Skill".
     */
    public Skill() {
        // Constructeur public et sans argument
    }

    /**
     * Retourbe le nom de la compétence.
     *
     * @return le nom
     */
    public String getName() {
        return name;
    }

    /**
     * Modifie le nom de la compétence.
     *
     * @param name le nouveau nom
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Redéfini la méthode toString héritée de java.lang.Object pour avoir une
     * représentation textuelle lisible de l'objet dans le debugger, dans la
     * console et dans les fichiers de logs.
     */
    @Override
    public String toString() {
        return "Skill [name=" + name + "]";
    }
}