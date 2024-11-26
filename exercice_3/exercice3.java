
public class StockManager {
     

    private String typeOperation;
    private String produit;
    private int quantite;
    private int stock;
    // Constantes pour les types d'opérations
    private static final String AJOUT = "ajout";
    private static final String RETRAIT = "retrait";

    /**
     * Gère le stock d'un produit en fonction de l'opération demandée.
     *
     * @param typeOperation Le type d'opération ("ajout" ou "retrait").
     * @param produit       Le nom du produit.
     * @param quantite      La quantité à ajouter ou retirer.
     * @param stock         Le stock actuel.
     * @return Le stock mis à jour après l'opération.
     */
    public int gererStock(String typeOperation, String produit, int quantite, int stock) {
     

        // Gestion des opérations
        switch (typeOperation.toLowerCase()) {
            case AJOUT:
                return ajouterStock(produit, quantite, stock);
            case RETRAIT:
                return retirerStock(produit, quantite, stock);
            default:
                System.out.println("Opération inconnue : " + typeOperation);
                return stock;
        }
    }

    /**
     * Ajoute une quantité au stock du produit.
     *
     * @param produit  Le nom du produit.
     * @param quantite La quantité à ajouter.
     * @param stock    Le stock actuel.
     * @return Le stock mis à jour après l'ajout.
     */
    private int ajouterStock(String produit, int quantite, int stock) {
        stock += quantite;
        System.out.println("Produit : " + produit + ", Stock après ajout : " + stock);
        return stock;
    }

    /**
     * Retire une quantité du stock du produit.
     *
     * @param produit  Le nom du produit.
     * @param quantite La quantité à retirer.
     * @param stock    Le stock actuel.
     * @return Le stock mis à jour après le retrait.
     * @throws IllegalStateException si le stock est insuffisant.
     */
    private int retirerStock(String produit, int quantite, int stock) {
        if (stock >= quantite) {
            stock -= quantite;
            System.out.println("Produit : " + produit + ", Stock après retrait : " + stock);
            return stock;
        } else {
            System.out.println("Stock insuffisant pour le produit : " + produit);
            return stock;
        }
    }
}
