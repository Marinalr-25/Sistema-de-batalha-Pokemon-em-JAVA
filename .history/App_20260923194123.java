import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class App{
    public static void main (String[]args){
      Cores cor = new Cores();
      PokemonAgua poseidon= new PokemonAgua("Poseidon",1,135,15, 200);
      PokemonAgua aquaman= new PokemonAgua("Aquaman",1,110,15, 200);
      PokemonFogo raiva= new PokemonFogo("Raiva",1,110,25, 210);
      PokemonAr furacao= new PokemonAr("Furacão",1,100,20, 220);
      PokemonTerra tarzan= new PokemonTerra("Tarzan",1,100,20, 210);
      PokemonEletricidade thor= new PokemonEletricidade("Thor",1,100,20, 200);

      //Crie uma lista chamada pokemonSelvagem que vai guardar objetos do tipo Pokemon."
      ArrayList<Pokemon> pokemonSelvagem = new ArrayList<>();
      pokemonSelvagem.add(aquaman);
      pokemonSelvagem.add(raiva);
      pokemonSelvagem.add(furacao);
      pokemonSelvagem.add(tarzan);
      pokemonSelvagem.add(thor);

      Random random5 = new Random();
      Treinador treinadorVictor = new Treinador("Victor");
      treinadorVictor.getpokedex().adicionarPokemon(poseidon);

      
        System.out.println("=".repeat(30));
        System.out.println(cor.getAmarelo()+ cor.getNegrito() + "=== JOGO DO POKÉMON ===" + cor.getReset());
        System.out.println("=".repeat(30));
        Scanner escolha = new Scanner(System.in);
        System.out.print("\n1 - Pokédex\n2 - Batalhar\n3 - Sair\nSELEIONE UMA DAS OPÇÕES ACIMA: "); 
        int menu = escolha.nextInt();
        while(menu != 1 && menu != 2 && menu != 3){
              System.out.println("Opção inválida!\nDigite 1 - Ver pokedex | 2 - Para Capturar | 3 - Para sair do jogo");
              menu = escolha.nextInt();
            }

        // if(menu==1){
        //     System.out.println("\nVocê selecionou a opção Capturar");
            
        // }
        if(menu==1){
            System.out.println("\nVocê selecionou a opção Pokédex");
            System.out.println(" Pokedex " +  treinadorVictor.getpokedex());


        }
        else if(menu==2){
            System.out.println("\nVocê selecionou a opção Batalhar");

            boolean continuarBatalha = true;

            while(continuarBatalha){

              if (pokemonSelvagem.isEmpty()) {
              System.out.println("Você capturou todos os Pokémons! Parabéns");
              break;
              }
              //pokemon alvo
              int lenPokemonSelvagem = pokemonSelvagem.size();
              int oponente = random5.nextInt(lenPokemonSelvagem); //0 - 4
              Pokemon alvo = pokemonSelvagem.get(oponente);
              System.out.println("nome oponenete: " + cor.getVermelho() + alvo.getnome() + cor.getReset());

              //escolhe pokemon
              int lenpokedexVictor = treinadorVictor.getpokedex().qtdPokedex();
              System.out.println("Escolha seu Pokémon: ");
              System.out.println("Atualmente você possui: " + lenpokedexVictor + (lenpokedexVictor == 1 ? " Pokemon" : " Pokemons"));

              for (int i = 0; i < lenpokedexVictor; i++) {
                System.out.println(i+1 + " - Pokemon "+ treinadorVictor.getpokedex().getPokemon(i).getnome());
              }
              int pokemonEscolhido = escolha.nextInt();
              if (pokemonEscolhido >= 1 && pokemonEscolhido <= treinadorVictor.getpokedex().getPokemons().size())
              Pokemon escolhido = treinadorVictor.getpokedex().getPokemon(pokemonEscolhido - 1);

              //iniciar batalha
              Batalha batalha = new Batalha(escolhido,  alvo, treinadorVictor);
              boolean capturou = batalha.batalhar(); 

              //
              System.out.printf("%sSELEIONE UMA DAS OPÇÕES ABAIXO:%s \n1 - Batalhar Novamente\n2 - Ver Pokédex\n3 - Sair\n ", cor.getAmarelo(), cor.getReset()); 
              int escolhaAposBatalha = escolha.nextInt();

              System.out.println("opcao da escolha: " + escolhaAposBatalha);
              if (escolhaAposBatalha == 1){
                //batalhar novamente
              } else if (escolhaAposBatalha == 2){
                System.out.println(" Pokedex " +  treinadorVictor.getpokedex());
                for (Pokemon pokemon : treinadorVictor.getpokedex().getlistaPokemons()) {
                  System.out.println("- " + pokemon.getnome());
                }
                System.out.println(" Pokemons disponiveis para captura: ");
                for (Pokemon pokemon : pokemonSelvagem) {
                  System.out.println("- " + pokemon.getnome());
                }

              }else if (escolhaAposBatalha == 3){
                continuarBatalha = false;
                System.out.println("Você saiu do jogo!");
              }
              
              if(capturou){
                pokemonSelvagem.remove(alvo);  
              }
            }
        }
        else if(menu==3){
            System.out.println("\nVocê saiu do jogo");
        }
        else{
            System.out.println("\nOpcão inválida");
        }
        escolha.close();
    }
}


