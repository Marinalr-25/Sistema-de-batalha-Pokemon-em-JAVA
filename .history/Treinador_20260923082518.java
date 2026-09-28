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


// 60 - 40%
// 200 max 100 50$ 60 %80



//base 100
// 5% - 100
// 10% - 90

//calcular a porcentagem do hp restante com a base
//base 100
//20% - 80 - 160
//30% - 70 - 140
//40% - 60 - 120
//60% - 40 - 80
//80% - 20 - 40
//90% - 10 - 20
//porcentagem chance - base100 - base 200
//90 - 10 - 20 - 10%
//95% - 5 - 10 - 5%

