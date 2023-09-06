package itispaleocapa.gherardid;

public class Main {
    public static void main(String[] args) {
        Circolo circolo = new Circolo();
        circolo.load();
        circolo.aggiungiPartecipante("Mario", "Rossi", 20, 'M');
        circolo.modificapartecipante(0, "Martina", "Mangili", 18, 'F');
        circolo.aggiungiPartecipante("Giuseppe", "Verdi", 25, 'M');
        circolo.save();
        //circolo.rimuoviPartecipante(0);
        circolo.print();
    }
}