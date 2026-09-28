public class Cores {
  private String amarelo;

  public Cores() {
    this.amarelo = "\033[33m";
    this.vermelho = "\033[31m";
    this.verde = "\033[32m";
    this.azul = "\033[34m";
    this.ciano = "\033[36m";
    this.roxo = "\033[35m";
    }
    public String getAmarelo() {
        return amarelo;
    }

    public String getVermelho() {
        return vermelho;
    }

    public String getVerde() {
        return verde;
    }

    public String getAzul() {
        return azul;
    }

    public String getCiano() {
        return ciano;
    }

    public String getRoxo() {
        return roxo;
    }
  
}
