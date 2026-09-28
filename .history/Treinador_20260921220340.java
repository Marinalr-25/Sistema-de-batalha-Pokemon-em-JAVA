public class Treinador {

  private String nome;
  private Pokedex pokedex;

  public Treinador(String nome, Pokedex pokedex){
    this.nome = nome;
    this.pokedex = pokedex;
  }

  public void getnome(){
    return nome;
  }
  public void setnome(String nome){
    this.nome = nome;
  }

  public void getnome(){
    return pokedex;
  }
  public void setnome(Pokedex pokedex){
    this.pokedex = pokedex;
  }
  
}
