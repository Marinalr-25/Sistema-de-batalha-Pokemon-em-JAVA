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

  @Override 
  public String toString(){
    return nome + pokedex;
  }
  
}


//20% - 45
//40% - 35
//60% - 25
//80% - 15
//100% - 5


// 50 de vida - 20%
// 40 de vida - 30%
// 30 de vida - 40%
// 20 de vida - 50%
// 10 de vida - 30%
// 05 de vida - 30%