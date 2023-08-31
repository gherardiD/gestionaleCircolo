package circolo.src.main.java.itispaleocapa.gherardid;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

public class Circolo {
  LinkedList<Partecipante> partecipanti;

  public Circolo() {
    partecipanti = new LinkedList<Partecipante>();
  }

  public void save() {
    try{
      //create an output stream to save the object to a file
      FileOutputStream fileOut = new FileOutputStream("C:\\\\Users\\\\danig\\\\OneDrive\\\\Desktop\\\\5IA\\\\compitiVacanze\\\\informatica\\\\gestionaleCircolo\\\\circolo\\\\src\\\\main\\\\java\\\\itispaleocapa\\gherardid\\data.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      //Serialize and save the object
      out.writeObject(partecipanti);
      //close the streams
      out.close();
      fileOut.close();
    }catch(IOException i){
      i.printStackTrace();
    }
  }

  public void load() {
    try{
      //create an input stream to load the object from a file
      FileInputStream fileIn = new FileInputStream("C:\\Users\\danig\\OneDrive\\Desktop\\5IA\\compitiVacanze\\informatica\\gestionaleVoli\\gestionalevoli\\src\\main\\java\\gestionale\\data.ser");
      ObjectInputStream in = new ObjectInputStream(fileIn);

      //load the object from the file
      partecipanti = (LinkedList<Partecipante>) in.readObject();

      //close the streams
      in.close();
      fileIn.close();
    }catch(IOException i){
      i.printStackTrace();
      return;
    }catch(ClassNotFoundException c){
      System.out.println("Class not found");
      c.printStackTrace();
      return;
    }
  }

  
  
  public int aggiungiPartecipante(String nome, String cognome, int eta, char sesso) {
    Partecipante p = new Partecipante(nome, cognome, eta, sesso);
    partecipanti.add(p);
    return p.getCodice();
  }

  public Partecipante modificapartecipante(int codice, String nome, String cognome, int eta, char sesso) {
    /*
     * .findFirst().orElse(null) is used when you want to find the first element in a stream
     * (or sequence) and return it as a value or provide null if the stream is empty. 
     */
    Partecipante p = partecipanti.stream().filter(partecipante -> partecipante.getCodice() == codice).findFirst().orElse(null);
    if (p != null) {
      p.setNome(nome);
      p.setCognome(cognome);
      p.setEta(eta);
      p.setSesso(sesso);
    }
    return p;
  }

  public void rimuoviPartecipante(int codice) {
    partecipanti.removeIf(p -> p.getCodice() == codice);
  }

  public void incrementaEta() {
    partecipanti.forEach(p -> p.setEta(p.getEta() + 1));
  }

  public double etaMedia() {
    return partecipanti.stream()
                      .mapToInt(Partecipante::getEta) // Extract ages
                      .average()                      // Calculate average
                      .orElse(0);               // Default to 0 if no participants
  }

  public double[] etaMediaSesso() {
    //posizione 0 maschi, posizione 1 femmine
    double[] medie = new double[2];
    medie[0] = partecipanti.stream()
                                  .filter(p -> p.getSesso() == 'M')
                                  .mapToInt(Partecipante::getEta)
                                  .average()
                                  .orElse(0);
    medie[1] = partecipanti.stream()
                                  .filter(p -> p.getSesso() == 'F')
                                  .mapToInt(Partecipante::getEta)
                                  .average()
                                  .orElse(0);
    return medie;
  }

  public float[] distribuzioneSesso() {
    //risulato espresso in percentuale
    //posizione 0 maschi, posizione 1 femmine
    float[] distribuzione = new float[2];
    int numero_maschi = (int) partecipanti.stream()
                              .filter(p -> p.getSesso() == 'M')
                              .count();
    distribuzione[0] = (numero_maschi * 100) / partecipanti.size();
    distribuzione[1] = 100 - distribuzione[0];
    return distribuzione;
  }

  //getters
  public LinkedList<Partecipante> getPartecipanti() {
    return partecipanti;
  }
}
