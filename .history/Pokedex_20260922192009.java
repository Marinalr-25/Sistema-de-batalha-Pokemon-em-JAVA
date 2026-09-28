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

    //perguntar esse
    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public qtdPokedex(){
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