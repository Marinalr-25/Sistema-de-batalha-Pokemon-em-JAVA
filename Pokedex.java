import java.util.ArrayList;

public class Pokedex {
    //Vai possui uma lista de pokemons que só pode armazenar objetos do tipo Pokemon
    private ArrayList<Pokemon> pokemons;

    //Cria uma lista vazia da Pokedex
    public Pokedex(){
      pokemons = new ArrayList<>();
    }

    //metodo para adicionar pokemon
    public void adicionarPokemon(Pokemon pokemon){
      pokemons.add(pokemon);
    }
    //metodo para remover pokemon
    public void removerPokemon(Pokemon pokemon){
      pokemons.remove(pokemon);
    }

    //pega a lista de pokemons
    public ArrayList<Pokemon> getlistaPokemons() {
      return pokemons;
    }
    
    //pega um pokemon da lista
    public Pokemon getPokemon(int i) {
        return pokemons.get(i);
    }

    public int qtdPokedex(){
      return pokemons.size();
    }

    // toString() serve para definir como o objeto será representado em texto
    @Override
      public String toString() {
          return pokemons.toString();
      }
  }
