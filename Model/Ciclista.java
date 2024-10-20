package Model;

import java.time.LocalTime;

public class Ciclista extends Participante {
  private Etapa[] etapas = new Etapa[20];
  private int etapasRealizadas = -1;

  Ciclista(String nome, String numero, String cidadeOrigem) {
    super(nome, numero, cidadeOrigem);
  }

  private void validaEtapas(Ciclista outro) throws Exception {
    if (this.etapasRealizadas < 0 || outro.etapasRealizadas < 0) throw new Exception("Um dos ciclistas ainda não possui etapas relaizadas");

    if (this.etapasRealizadas != outro.etapasRealizadas) throw new Exception("Etapas Divergentes");
  }

  public Duracao getDuracaoTotal() {
    int somaTotal = 0;

    for (int i = 0; i <= etapasRealizadas; i++) {
      somaTotal += etapas[i].getDuracao().getDuracaoEmSegundos();
    }

    return new Duracao(LocalTime.of(0, 0, somaTotal));
  }

  public LocalTime isMelhorTempo(Ciclista outro) throws Exception {
    validaEtapas(outro);

    if (this.getDuracaoTotal().getDuracaoEmSegundos() > outro.getDuracaoTotal().getDuracaoEmSegundos()) {
      return LocalTime.of(0, 0, this.getDuracaoTotal().getDuracaoEmSegundos());
    }

    if (this.getDuracaoTotal().getDuracaoEmSegundos() < outro.getDuracaoTotal().getDuracaoEmSegundos()) {
      return LocalTime.of(0, 0, outro.getDuracaoTotal().getDuracaoEmSegundos());
    }

    return null;
  }

  public Ciclista isMelhor(Ciclista outro) throws Exception {
    validaEtapas(outro);

    if (this.getDuracaoTotal().getDuracaoEmSegundos() > outro.getDuracaoTotal().getDuracaoEmSegundos()) {
      return this;
    }

    if (this.getDuracaoTotal().getDuracaoEmSegundos() < outro.getDuracaoTotal().getDuracaoEmSegundos()) {
      return outro;
    }

    return null;
  }

  public Ciclista isMelhor(Ciclista outro, int idEtapa) throws Exception {
    validaEtapas(outro);

    if (this.etapas[idEtapa].getDuracao().getDuracaoEmSegundos() > outro.etapas[idEtapa].getDuracao().getDuracaoEmSegundos()) {
      return this;
    }

    if (this.etapas[idEtapa].getDuracao().getDuracaoEmSegundos() < outro.etapas[idEtapa].getDuracao().getDuracaoEmSegundos()) {
      return outro;
    }

    return null;
  }
}

/*
 * 
 * 
 * [CADASTRANDO] INPUT_USER -> VIEW -> CONTROLLER ->  BD
 * [LIST] SELECT_OPTION -> VIEW -> CONTROLLER -> BD -> CONTROLLR -> VIEW
 *  
 */
