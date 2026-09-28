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

//proporsional a vida de cada pokemon
// 100 - 45
// 135 - x


//base 100
//20% - 45
//40% - 35
//60% - 25
//80% - 15
//100% - 5

