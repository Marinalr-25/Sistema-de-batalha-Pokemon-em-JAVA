
public class Treinador {

  //Atributos da classe Treinador
  private String nome;
  private Pokedex pokedex;

  
  public Treinador(String nome){
    this.nome = nome;
    this.pokedex = new Pokedex();
  }

  public String getNome(){
    return  nome;
  }

  public Pokedex getPokedex(){
    return pokedex;
  }
}

