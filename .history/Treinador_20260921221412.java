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
  public void setnome(String nome){
    this.nome = nome;
  }

  public String getpokedex(){
    return pokedex;
  }
  public void setpokedex(String pokedex){
    this.pokedex = pokedex;
  }
  
}
