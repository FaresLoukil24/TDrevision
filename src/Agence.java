import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures vs;
    private Map<Client, ListVoitures> clientVoitureLoue = new HashMap<>();

    public void setClientVoitureLoue(Map<Client, ListVoitures> clientVoitureLoue) {
        this.clientVoitureLoue = clientVoitureLoue;
    }

    public Agence(String nom) {
        this.nom = nom;
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        if (v == null) {
            throw new VoitureException("La voiture est nulle");
        }
        vs.ajoutVoiture(v);
    }

    public void suppVoiture(Voiture v) throws VoitureException {
        if (v == null) {
            throw new VoitureException("La voiture est nulle");
        }
        vs.supprimeVoiture(v);
    }
    public void louerVoiture(Client client, Voiture voiture) throws VoitureException {
        if (!clientVoitureLoue.containsKey(client)) {
            clientVoitureLoue.put(client, new ListVoitures());
        }
        clientVoitureLoue.get(client).ajoutVoiture(voiture);
    }
    public void retournerVoiture(Client client, Voiture voiture) throws VoitureException {
        if (clientVoitureLoue.containsKey(client)) {
            if(!clientVoitureLoue.get(client).getVoitures().isEmpty())
                clientVoitureLoue.get(client).supprimeVoiture(voiture);
            else
                clientVoitureLoue.remove(client);
        }else
            throw new VoitureException("Voiture n'existe pas dans ce client");
    }


    public List<Voiture> selectVoitureSelonCritere(Critere c) {
        List<Voiture> voituresSelectionnees = new ArrayList<>();
        for (Voiture v : vs.getVoitures()) {
            if (c.estSatisfaitPar(v)) {
                voituresSelectionnees.add(v);
            }
        }
        return voituresSelectionnees;
    }


    public Set<Client> clientsAyantLoueVoiture() {
        return clientVoitureLoue.keySet();
    }

    public List<Voiture> voituresEnLocation() {
        List<Voiture> voituresEnLocation = new ArrayList<>();
        for (ListVoitures listeVoituresLouees : clientVoitureLoue.values()) {
            voituresEnLocation.addAll(listeVoituresLouees.getVoitures());
        }
        return voituresEnLocation;
    }
    public void afficheLesClientsEtLeursListesVoitures(){
        for (Map.Entry<Client, ListVoitures> map : clientVoitureLoue.entrySet()) {
            System.out.println("Client: " + map.getKey().getNom() + " " + map.getKey().getPrenom());
            for (Voiture voiture : map.getValue().getVoitures()) {
                System.out.println(voiture.getImmariculation() + " / " + voiture.getMarque());
            }
        }
    }
    public void trierClientsParCode(List<Client> clients) {
        Collections.sort(clients, new triCodeCroissant());
    }

    public void trierClientsParNom(List<Client> clients) {
        Collections.sort(clients, new triNomCroissant());
    }
}