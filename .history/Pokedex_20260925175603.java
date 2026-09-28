import java.util.ArrayList;
// import java.util.HashMap;

public class Pokedex {
    private ArrayList<Pokemon> pokemons;

    public Pokedex(){
      pokemons = new ArrayList<>();
    }

    public void adicionarPokemon(Pokemon pokemon){
      pokemons.add(pokemon);
    }
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
