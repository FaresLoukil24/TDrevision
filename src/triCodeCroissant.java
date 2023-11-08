import java.util.Comparator;

public class triCodeCroissant implements Comparator<Client> {

    @Override
    public int compare(Client o1, Client o2) {
        return o2.getCode()- o1.getCode();
    }
}
