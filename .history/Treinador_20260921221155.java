public class Treinador {

  private String nome;
  private String pokedex;

  public Treinador(String nome, String pokedex){
    this.nome = nome;
    this.pokedex = pokedex;
  }

  public String getnome(){
    return  nome;
  }
  public String setnome(String nome){
    this.nome = nome;
  }

  public String getnome(){
    return pokedex;
  }
  public String setnome(String pokedex){
    this.pokedex = pokedex;
  }
  
}
