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
  }