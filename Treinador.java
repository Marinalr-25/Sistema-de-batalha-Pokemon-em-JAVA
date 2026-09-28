
public class Treinador {

  //Atributos da classe Treinador
  private String nome;
  private Pokedex pokedex;


  //construtor recebe o nome e pokedex é uma classe do tipo pokedex
  public Treinador(String nome){
    this.nome = nome;
    this.pokedex = new Pokedex();
  }

  //metodo de acesso
  public String getNome(){
    return  nome;
  }

  //Cada Treinador é criado ja com uma Pokedex
  public Pokedex getPokedex(){
    return pokedex;
  }
}

