import java.util.Comparator;

public class triNomCroissant implements Comparator<Client> {

    @Override
    public int compare(Client o1, Client o2) {
        return o2.getNom().compareTo(o1.getNom());
    }
}
