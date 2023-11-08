public class CriterePrix implements Critere {
    private float prix;

    public CriterePrix(float prix) {
        this.prix = prix;
    }
    public boolean estSatisfaitPar(Voiture v) {
if (prix==v.getPrixLocation()){
    return true;
}
else return false;
    }
}