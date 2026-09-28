public class Cores {
  private String preto;
  private String vermelho;
  private String verde;
  private String amarelo;
  private String azul;
  private String roxo;
  private String ciano;
  private String branco;
  private String cinza;
  private String negrito;
  private String sublinhado;
  private String reset;

  public Cores() {
    this.preto = "\033[30m";
    this.vermelho = "\033[31m";
    this.verde = "\033[32m";
    this.amarelo = "\033[33m";
    this.azul = "\033[34m";
    this.roxo = "\033[35m";
    this.ciano = "\033[36m";
    this.branco = "\033[37m";
    this.cinza = "\033[90m";
    this.negrito = "\033[1m";
    this.sublinhado = "\033[4m";
    this.reset = "\033[0m";
    }


    public String getPreto() {
        return preto;
    }
    public String getVermelho() {
    return vermelho;
    }
    public String getVerde() {
        return verde;
    }
    public String getAmarelo() {
        return amarelo;
    }
    public String getAzul() {
        return azul;
    }
    public String getRoxo() {
        return roxo;
    }
    public String getCiano() {
        return ciano;
    }
    public String getBranco() {
        return branco;
    }
    public String getCinza() {
        return cinza;
    }
    public String getNegrito() {
        return negrito;
    }
    public String getSublinhado() {
        return sublinhado;
    }
    public String getReset() {
        return reset;
    }
}
