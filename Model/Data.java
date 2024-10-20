package Model;

public class Data {
  private int dia;
  private int mes;
  private int ano;

  public Data(int dia, int mes, int ano) {
      this.ajustar(dia, mes, ano);
  }

  public void ajustar(int dia, int mes, int ano) {
      this.dia = dia;
      this.mes = mes;
      this.ano = ano;
      validar();
  }

  private void validar() {
      if (ano < 0) {
          throw new IllegalArgumentException("Ano inválido");
      }
      if (mes < 1 || mes > 12) {
          throw new IllegalArgumentException("Mês inválido");
      }
      if (dia < 1 || dia > diasNoMes(mes, ano)) {
          throw new IllegalArgumentException("Dia inválido");
      }
  }

  private int diasNoMes(int mes, int ano) {
      switch (mes) {
          case 1: case 3: case 5: case 7: case 8: case 10: case 12:
              return 31;
          case 4: case 6: case 9: case 11:
              return 30;
          case 2:
              return (anoBissexto(ano)) ? 29 : 28;
          default:
              return 0;
      }
  }

  private boolean anoBissexto(int ano) {
      return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
  }

  public String dataFormatada() {
      return String.format("%02d/%02d/%04d", dia, mes, ano);
  }

  public boolean estaAntesDe(Data outraData) {
      if (this.ano < outraData.ano) return true;
      if (this.ano == outraData.ano && this.mes < outraData.mes) return true;
      return this.ano == outraData.ano && this.mes == outraData.mes && this.dia < outraData.dia;
  }

  public boolean estaDepoisDe(Data outraData) {
      if (this.ano > outraData.ano) return true;
      if (this.ano == outraData.ano && this.mes > outraData.mes) return true;
      return this.ano == outraData.ano && this.mes == outraData.mes && this.dia > outraData.dia;
  }
}
