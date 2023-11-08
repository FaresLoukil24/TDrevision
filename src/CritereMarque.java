public class CritereMarque implements Critere {
    private String marque;
    public CritereMarque(String marque) {
        this.marque = marque;
    }
    public boolean estSatisfaitPar(Voiture v) {
if (marque == v.getMarque()){
    return true;
}
else
    return false;
    }
}