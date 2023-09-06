package testgestionale;



import org.junit.Test;
import static org.junit.Assert.assertEquals;

import itispaleocapa.gherardid.*;

public class AppTest {
  @Test
  public void testPartecipante() {
    Partecipante p = new Partecipante("Mario", "Rossi", 20, 'M');
    assertEquals("Mario", p.getNome());
    assertEquals("Rossi", p.getCognome());
    assertEquals(20, p.getEta());
    assertEquals('M', p.getSesso());
    assertEquals(0, p.getCodice());
    p.setNome("Martina");
    assertEquals("Martina", p.getNome());
  }

  @Test
  public void testCircolo() {
    Circolo circolo = new Circolo();
    assertEquals(0, circolo.getPartecipanti().size());
    int cod = circolo.aggiungiPartecipante("Mario", "Rossi", 20, 'M');
    assertEquals(0, cod);
    assertEquals(1, circolo.getPartecipanti().size());
    circolo.modificapartecipante(cod, "Martina", "Bianchi", 22, 'F');
    circolo.aggiungiPartecipante("Daniele", "Gherardi", 18, 'M');
    assertEquals(20, circolo.etaMedia(), 0.01);
    assertEquals(18, circolo.etaMediaSesso()[0], 0.01);
    assertEquals(22, circolo.etaMediaSesso()[1], 0.01);
    assertEquals(50, circolo.distribuzioneSesso()[0], 0.01);
    
    
    circolo.rimuoviPartecipante(cod);
    assertEquals(1, circolo.getPartecipanti().size());

  }
}
