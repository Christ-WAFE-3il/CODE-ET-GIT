
public class FactureManager {



    private String typeProduit;
    private int quantite;
    private double prixUnitaire;
    // Constantes pour les taux de réduction
    private static final double REDUCTION_ALIMENTAIRE = 0.05;
    private static final double REDUCTION_ELECTRONIQUE = 0.10;
    private static final double REDUCTION_LUXE = 0.15;
    private static final double REDUCTION_GROS_MONTANT = 0.05;
    private static final double SEUIL_GROS_MONTANT = 1000.0;
   

    /**
     * Calcule le total d'une facture avec les réductions applicables.
     *
     * @param typeProduit Le type du produit (ex. "Alimentaire", "Electronique", "Luxe").
     * @param quantite    La quantité de produits achetés.
     * @param prixUnitaire Le prix unitaire du produit.
     * @return Le total après application des réductions.
     * @throws IllegalArgumentException si les entrées sont invalides.
     */
    public double calculerFacture(String typeProduit, int quantite, double prixUnitaire) {
       
        // Calcul du total
        double total = quantite * prixUnitaire;

        // Application des réductions selon le type de produit
        switch (typeProduit) {
            case "Alimentaire":
                total -= total * REDUCTION_ALIMENTAIRE;
                break;
            case "Electronique":
                total -= total * REDUCTION_ELECTRONIQUE;
                break;
            case "Luxe":
                total -= total * REDUCTION_LUXE;
                break;
            default:
                
                System.out.println("Aucune réduction spécifique pour le type de produit : " + typeProduit);
        }

        // Réduction supplémentaire pour les gros montants
        if (total > SEUIL_GROS_MONTANT) {
            total -= total * REDUCTION_GROS_MONTANT;
        }

        return total;
    }
}
