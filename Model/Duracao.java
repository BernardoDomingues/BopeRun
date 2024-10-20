package Model;

public class Duracao {
  private Hora horaInicial;
  private int duracaoTotal;

  public Duracao(Hora horaInicial, int tempoEmSegundos) {
      this.horaInicial = horaInicial;
      this.duracaoTotal = tempoEmSegundos;
  }

  public boolean maiorQue(Duracao outraDuracao) {
      return this.duracaoTotal > outraDuracao.duracaoTotal;
  }

  public int duracaoEmSegundos() {
      return duracaoTotal;
  }

  public String relatorio() {
      int horas = duracaoTotal / 3600;
      int minutos = (duracaoTotal % 3600) / 60;
      int segundos = duracaoTotal % 60;
      return String.format("Duração: %02d horas, %02d minutos, %02d segundos", horas, minutos, segundos);
  }
}

