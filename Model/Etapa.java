package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Etapa {
  private int numero;
  private LocalDate data;
  private LocalTime horaInicial;
  private Duracao duracao;

  Etapa(int numero) {
    this.numero = numero;
    this.data = LocalDate.now();
    this.horaInicial = LocalTime.now();
  }

  public Duracao getDuracao() {
    return duracao;
  }
}
