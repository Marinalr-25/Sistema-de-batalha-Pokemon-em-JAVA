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

    //pega a lista de pokemons
    public ArrayList<Pokemon> getPokemons() {
      return pokemons;
    }
    
    
    //pega um pokemon da lista
    public Pokemon getPokemon(int i) {
        return pokemons.get(i);
    }

    public int qtdPokedex(){
      return pokemons.size();
    }



    //Java automaticamente tenta fazer: treinador.getpokedex().toString()
    @Override
      public String toString() {
          return pokemons.toString();
      }

  }

  //treinador.getpokedex()
//         ↓
//       Pokedex
//         ↓
//    pokemons.toString()
//         ↓
// cada Pokemon.toString()
//         ↓
// "Thor | Tipo: Elétrico | HP: 100"