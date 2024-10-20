package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Etapa {
  private static int numeroContador = 1;
  private int numero;
  private Data data;
  private Hora horaInicial;
  private Duracao duracao;

  Etapa() {
    this.numero = numeroContador;
    this.data = new Data(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());
    this.horaInicial = new Hora(LocalTime.now().getHour(), LocalTime.now().getMinute(), LocalTime.now().getSecond());
    numeroContador++;
  }

  public Duracao getDuracao() {
    return duracao;
  }
}
