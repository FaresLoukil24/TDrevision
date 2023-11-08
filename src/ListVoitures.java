import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListVoitures{

    private List<Voiture> voitures;
    public ListVoitures(List<Voiture> voitures) {
    this.voitures=voitures;
    }
    public ListVoitures() {
        this.voitures = new ArrayList<>();
    }
    public List<Voiture> getVoitures() {
        return voitures;
    }
    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }
    public void ajoutVoiture(Voiture v) throws VoitureException {
        if (v == null) {
            throw new VoitureException("La voiture est nulle");
        }
        voitures.add(v);
    }
    public void supprimeVoiture(Voiture v) throws VoitureException {
        if (v == null) {
            throw new VoitureException("La voiture est nulle");
        }
        voitures.remove(v);
    }
    public Iterator<Voiture> iterateur(){
        return voitures.iterator();
    }
    public int size(){
        return voitures.size();
    }
    public void affiche() {
        for (Voiture v : voitures) {
            System.out.println(v);
        }
    }


}