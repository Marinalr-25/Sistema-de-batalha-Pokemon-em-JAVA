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
      Scanner escolha = new Scanner(System.in);

      System.out.println("=".repeat(30));
      System.out.println(cor.getAmarelo()+ cor.getNegrito() + "=== JOGO DO POKÉMON ===" + cor.getReset());
      System.out.println("=".repeat(30));

      Treinador treinadorJoaozinho = new Treinador("Joãozinho");
      treinadorJoaozinho.getpokedex().adicionarPokemon(poseidon);

      Treinador treinadorMariazinha = new Treinador("Mariazinha");
      treinadorMariazinha.getpokedex().adicionarPokemon(raiva);

      
      int escolhaTreinador;

      System.out.printf("     %sESCOLHA SEU TREINADOR%s%n", cor.getAzul(), cor.getReset());
      
      do{
        System.out.println("1 - " + treinadorJoaozinho.getnome());
        System.out.println("2 - " + treinadorMariazinha.getnome());
        System.out.printf("Escolha seu treinador: ");
        escolhaTreinador = escolha.nextInt();
        System.out.println("================================");

        if(escolhaTreinador != 1 && escolhaTreinador != 2){
          System.out.println("Opção inválida! Digite 1 ou 2 ");
        }
      } while (escolhaTreinador != 1 && escolhaTreinador != 2);

      Treinador treinadorEscolhido;
      if(escolhaTreinador == 1){
        treinadorEscolhido = treinadorJoaozinho;
      } else{
        treinadorEscolhido = treinadorMariazinha;
      } 

        
        
        System.out.printf("%sSELEIONE UMA DAS OPÇÕES ABAIXO:%s\n1 - Pokédex\n2 - Batalhar\n3 - Sair\n ", cor.getAzul(), cor.getReset()); 
        int menu = escolha.nextInt();
        while(menu != 1 && menu != 2 && menu != 3){
              System.out.println("Opção inválida!\nDigite 1 - Ver pokedex | 2 - Para Capturar | 3 - Para sair do jogo");
              menu = escolha.nextInt();
            }

        if(menu==1){
            System.out.println("\nVocê selecionou a opção Pokédex");
            System.out.println(" Pokedex do(a) " + treinadorEscolhido.getnome()+ ": " +  treinadorJoaozinho.getpokedex());


        }
        else if(menu==2){
            System.out.println("------------------------------");
            System.out.println("\nVocê selecionou a opção Batalhar");

            boolean continuarBatalha = true;

            while(continuarBatalha){
              int lenPokemonSelvagem = pokemonSelvagem.size();
              int oponente = random5.nextInt(lenPokemonSelvagem); //0 - 4
              Pokemon alvo = pokemonSelvagem.get(oponente);
              System.out.printf("%s===INICIANDO BATALHA===%s%n", cor.getAzul(), cor.getReset());
              System.out.println("nome oponente: " + cor.getVermelho() + alvo.getnome() + cor.getReset());

              //escolhe pokemon
              int lenpokedex = treinadorJoaozinho.getpokedex().qtdPokedex();
              System.out.println("Escolha seu Pokémon: ");
              System.out.println(cor.getRosa() + "Atualmente você possui: " + cor.getReset() + lenpokedex + (lenpokedex == 1 ? " Pokemon" : " Pokemons"));

              for (int i = 0; i < lenpokedex; i++) {
                System.out.println(i+1 + " - Pokemon "+ treinadorJoaozinho.getpokedex().getPokemon(i).getnome());
              }
              int pokemonEscolhido;

              do {
                  System.out.print("Digite o número do Pokémon que possui: ");
                  pokemonEscolhido = escolha.nextInt();

                  if (pokemonEscolhido < 1 || pokemonEscolhido > lenpokedex) {
                      System.out.println("Opção inválida! ");
                  }

              } while (pokemonEscolhido < 1 || pokemonEscolhido > lenpokedex);

              Pokemon escolhido = treinadorJoaozinho.getpokedex().getPokemon(pokemonEscolhido - 1);


              //iniciar batalha
              Batalha batalha = new Batalha(escolhido,  alvo, treinadorJoaozinho);
              boolean capturou = batalha.batalhar();
              
              if(capturou){
                pokemonSelvagem.remove(alvo);  
                if (pokemonSelvagem.isEmpty()) {
                  System.out.println();
                  System.out.println("================================");
                  System.out.println("VOCÊ CAPTUROU TODOS OS POKÉMON!");
                  System.out.println("PARABÉNS! VOCÊ VENCEU O JOGO!");
                  System.out.println("================================");
                  continuarBatalha = false;
                  break;
                }
              }

              //
              System.out.printf("%sSELEIONE UMA DAS OPÇÕES ABAIXO:%s \n1 - Batalhar Novamente\n2 - Ver Pokédex e batalhar\n3 - Sair\n ", cor.getAmarelo(), cor.getReset()); 
              int escolhaAposBatalha;
              System.out.println("-----------------------------------");

              do {
                  escolhaAposBatalha = escolha.nextInt();

                  if (escolhaAposBatalha < 1 || escolhaAposBatalha > 3) {
                      System.out.println("Opção inválida! ");
                  }

              } while (escolhaAposBatalha < 1 || escolhaAposBatalha > 3);

              System.out.println("opcao da escolha: " + escolhaAposBatalha);
              if (escolhaAposBatalha == 1){
                //batalhar novamente
              } else if (escolhaAposBatalha == 2){
                System.out.println("-----------------------------------");
                System.out.printf("%s Pokedex do(a) %s: %s%n", cor.getRosa(), treinadorJoaozinho.getnome(), cor.getReset());

                int indice = 1;
                for (Pokemon pokemon : treinadorJoaozinho.getpokedex().getlistaPokemons()) {
                    System.out.println(indice + " - " + pokemon);
                    indice++;
                }
                System.out.println("-----------------------------------\n");
                System.out.printf(" %s Pokemons disponiveis para captura: %s\n ", cor.getRosa(), cor.getReset());
                for (Pokemon pokemon : pokemonSelvagem) {
                  System.out.println("- " + pokemon.getnome());
                }
                System.out.println("-----------------------------------");

              }else if (escolhaAposBatalha == 3){
                continuarBatalha = false;
                System.out.println("Você saiu do jogo!");
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


