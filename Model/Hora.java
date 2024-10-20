package Model;

public class Hora {
  private int horas;
  private int minutos;
  private int segundos;

  public Hora(int horas, int minutos, int segundos) {
      this.ajustar(horas, minutos, segundos);
  }

  public void ajustar(int horas, int minutos, int segundos) {
      this.horas = horas;
      this.minutos = minutos;
      this.segundos = segundos;
      validar();
  }

  private void validar() {
      if (horas < 0 || horas > 23 || minutos < 0 || minutos > 59 || segundos < 0 || segundos > 59) {
          throw new IllegalArgumentException("Hora inválida");
      }
  }

  public Hora incrementar(int quantidadeSegundos) {
      int totalSegundos = horas * 3600 + minutos * 60 + segundos + quantidadeSegundos;
      int novasHoras = (totalSegundos / 3600) % 24;
      int novosMinutos = (totalSegundos % 3600) / 60;
      int novosSegundos = totalSegundos % 60;
      return new Hora(novasHoras, novosMinutos, novosSegundos);
  }

  public boolean estaNaFrenteDe(Hora outraHora) {
      if (this.horas > outraHora.horas) return true;
      if (this.horas == outraHora.horas && this.minutos > outraHora.minutos) return true;
      return this.horas == outraHora.horas && this.minutos == outraHora.minutos && this.segundos > outraHora.segundos;
  }

  public String horaFormatada() {
      return String.format("%02d:%02d:%02d", horas, minutos, segundos);
  }
}
