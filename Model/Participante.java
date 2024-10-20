package Model;

public class Participante {
  private String nome;
  private static int numeroContador = 1;
  private int numero;
  private String cidadeOrigem;

  Participante(String nome, int numero, String cidadeOrigem) {
    this.nome = nome;
    this.numero = numeroContador;
    this.cidadeOrigem = cidadeOrigem;
    numeroContador++;
  }
}
