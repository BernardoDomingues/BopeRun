package Model;

import java.time.LocalTime;

public class Duracao {
  private LocalTime duracao;

  public Duracao(LocalTime duracao) {
    this.duracao = duracao;
  }

  public int getDuracaoEmSegundos() {
    return duracao.getSecond();
  }

  public int compararCom(Duracao outra) {
    return Integer.compare(this.duracao.getSecond(), outra.duracao.getSecond());
  }

  @Override
  public String toString() {
    return duracao.toString();
  }
}
