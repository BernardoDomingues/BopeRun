package Model;

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
      somaTotal += etapas[i].getDuracao().duracaoEmSegundos();
    }

    return new Duracao(new Hora(0, 0, 0), somaTotal);
  }

  public Ciclista isMelhor(Ciclista outro) throws Exception {
    validaEtapas(outro);

    if (this.getDuracaoTotal().duracaoEmSegundos() > outro.getDuracaoTotal().duracaoEmSegundos()) {
      return this;
    }

    if (this.getDuracaoTotal().duracaoEmSegundos() < outro.getDuracaoTotal().duracaoEmSegundos()) {
      return outro;
    }

    return null;
  }

  public Hora isMelhorTempo(Ciclista outro) throws Exception {
    validaEtapas(outro);

    Ciclista melhor = isMelhor(outro);

    if (melhor == null) return null;
    
    return new Hora(0, 0, melhor.getDuracaoTotal().duracaoEmSegundos());
  }

  public Ciclista isMelhor(Ciclista outro, int idEtapa) throws Exception {
    validaEtapas(outro);

    if (this.etapas[idEtapa].getDuracao().duracaoEmSegundos() > outro.etapas[idEtapa].getDuracao().duracaoEmSegundos()) {
      return this;
    }

    if (this.etapas[idEtapa].getDuracao().duracaoEmSegundos() < outro.etapas[idEtapa].getDuracao().duracaoEmSegundos()) {
      return outro;
    }

    return null;
  }
}
