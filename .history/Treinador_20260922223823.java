// import java.util.ArrayList;

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

//proporcional a vida de cada pokemon
// 100 - 45
// 135 - x


//base 100
// 5% - 100
// 5% - 100

//20% - 45
//40% - 35
//60% - 25
//80% - 15
//100% - 5

