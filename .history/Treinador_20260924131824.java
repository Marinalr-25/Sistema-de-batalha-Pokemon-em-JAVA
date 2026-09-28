
public class Treinador {

  private String nome;
  private Pokedex pokedex;

  public Treinador(String nome){
    this.nome = nome;
    this.pokedex = new Pokedex();
  }

  public String getnome(){
    return  nome;
  }

  public Pokedex getpokedex(){
    return pokedex;
  }
}

