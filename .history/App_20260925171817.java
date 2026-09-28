import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class App{
    public static void main (String[]args){
      Cores cor = new Cores();
      Random random5 = new Random();
      Scanner escolha = new Scanner(System.in);

      //POKEMONS
      PokemonAgua poseidon= new PokemonAgua("Poseidon",-1,90,15, 200);
      PokemonAgua tsunami= new PokemonAgua("Tsunami",1,110,17, 200);
      PokemonFogo incendio = new PokemonFogo("Incêndio",1,80,15, 205);
      PokemonFogo brasa= new PokemonFogo("Brasa",1,100,25, 210);
      PokemonAr furacao= new PokemonAr("Furacão",1,120,25, 180);
      PokemonTerra terremoto= new PokemonTerra("Terremoto",1,100,20, 200);
      PokemonEletricidade trovao= new PokemonEletricidade("Trovão",1,100,20, 200);
      //TREINADORES
      Treinador treinadorJoaozinho = new Treinador("Joãozinho");
      treinadorJoaozinho.getPokedex().adicionarPokemon(poseidon);
      Treinador treinadorMariazinha = new Treinador("Mariazinha");
      treinadorMariazinha.getPokedex().adicionarPokemon(incendio);

      //Crie uma lista chamada pokemonSelvagem que vai guardar objetos do tipo Pokemon."
      ArrayList<Pokemon> pokemonSelvagem = new ArrayList<>();
      pokemonSelvagem.add(tsunami);
      pokemonSelvagem.add(brasa);
      pokemonSelvagem.add(furacao);
      pokemonSelvagem.add(terremoto);
      pokemonSelvagem.add(trovao);



      System.out.println("=".repeat(30));
      System.out.println(cor.getAmarelo()+ cor.getNegrito() + "=== JOGO DO POKÉMON ===" + cor.getReset());
      System.out.println("=".repeat(30));
      System.out.printf("     %sESCOLHA SEU TREINADOR%s%n", cor.getAzul(), cor.getReset());
      
      /// Verificação ao escolher Treinador, inválido para letras e números diferentes de 1 e 2
      int escolhaTreinador;
      do{
        System.out.println("1 - " + treinadorJoaozinho.getNome());
        System.out.println("2 - " + treinadorMariazinha.getNome());
        System.out.printf("Escolha seu treinador: ");
        //verificar se oq digitou é um número
        if(escolha.hasNextInt()){
          escolhaTreinador = escolha.nextInt();
          //verificar se o numero digitado é 1 ou 2
          if(escolhaTreinador != 1 && escolhaTreinador != 2){
            System.out.printf("%sOpção inválida! Digite 1 ou 2 %s%n", cor.getVermelho(), cor.getReset());
          }
          //se digitou letras, informa opção inválida, zera o scanner, e zera o treinador para continuar no while
        } else{
          System.out.printf("%sOpção inválida! Digite apenas números%s%n", cor.getVermelho(), cor.getReset());
          escolha.nextLine();
          escolhaTreinador = 0;
        }
      } while (escolhaTreinador != 1 && escolhaTreinador != 2);
      
      Treinador treinadorEscolhido;
      
      //Definindo treinador em base do q digitou, 1 ou 2
      if(escolhaTreinador == 1){
        treinadorEscolhido = treinadorJoaozinho;
        System.out.printf("Você escolheu %s\n", treinadorEscolhido.getNome());
        System.out.printf("O pokémon inicial de %s é o %s%s%s\n", treinadorEscolhido.getNome(),  cor.getAzul(),  treinadorEscolhido.getPokedex().getPokemon(0).getNome(), cor.getReset());

        System.out.printf("Atributos do seu Pokémon:%n %s%s%s \n",cor.getVerde(), treinadorEscolhido.getPokedex(), cor.getReset());
        System.out.println("================================");
      } else{
        treinadorEscolhido = treinadorMariazinha;
        System.out.printf("Você escolheu %s\n", treinadorEscolhido.getNome());
        System.out.printf("O pokémon inicial de %s é o %s%s%s\n", treinadorEscolhido.
        getNome(), cor.getVermelho(), treinadorEscolhido.getPokedex().getPokemon(0).getNome(), cor.getReset() );
        System.out.printf("Atributos do seu Pokémon:%n %s%s%s \n",cor.getVerde(), treinadorEscolhido.getPokedex(), cor.getReset());

        System.out.println("================================");
      } 

      //Verificação ao escolher Opções após escolher treinador, inválido para letras e números diferentes de 1, 2 e 3
      int menu;
      do{
        System.out.printf("%sSELEIONE UMA DAS OPÇÕES ABAIXO:%s\n1 - Pokédex\n2 - Batalhar\n3 - Sair\n ", cor.getAzul(), cor.getReset()); 
        if (escolha.hasNextInt()){
          menu = escolha.nextInt();
          if (menu != 1 && menu != 2 & menu != 3){
            System.out.printf("%sOpção inválida! Digite 1, 2 ou 3 %s%n", cor.getVermelho(), cor.getReset());
          }
        } else{
          System.out.printf("%sOpção inválida! Digite apenas números%s%n", cor.getVermelho(), cor.getReset());
          escolha.nextLine();
          menu = 0;
        }
      } while (menu != 1 && menu != 2 & menu != 3 );
        if(menu==1){
            System.out.println("\nVocê selecionou a opção Pokédex");
            System.out.println(" Pokedex do(a) " + treinadorEscolhido.getNome()+ ": " +  treinadorEscolhido.getPokedex());
        }else if(menu==2){
            System.out.println("------------------------------");
            System.out.println("\nVocê selecionou a opção Batalhar");

            //inicia a batalha novamente
            boolean continuarBatalha = true;
            while(continuarBatalha){
              //Verifica a lista de pokemons selvagens para sortear um oponente
              int lenPokemonSelvagem = pokemonSelvagem.size();
              int oponente = random5.nextInt(lenPokemonSelvagem); //0 - 4
              Pokemon alvo = pokemonSelvagem.get(oponente);
              System.out.printf("%s===INICIANDO BATALHA===%s%n", cor.getAzul(), cor.getReset());
              System.out.println("nome oponente: " + cor.getVermelho() + alvo.getNome() + cor.getReset());

              //escolhe o seu pokemon
              int lenpokedex = treinadorEscolhido.getPokedex().qtdPokedex();
              System.out.println("Escolha seu Pokémon: ");
              System.out.println(cor.getRosa() + "Atualmente você possui: " + cor.getReset() + lenpokedex + (lenpokedex == 1 ? " Pokemon" : " Pokemons"));

              //Informa cada pokemon que possui
              for (int i = 0; i < lenpokedex; i++) {
                System.out.println(i+1 + " - Pokemon "+ treinadorEscolhido.getPokedex().getPokemon(i).getNome());
              }
              int pokemonEscolhido;

              //Verifica se digitou letras ou numeros diferentes da lista da pokedex do treinador
              do {
                  System.out.print("Digite o número do Pokémon que possui: ");
                  if(escolha.hasNextInt()){
                    pokemonEscolhido = escolha.nextInt();
                    if(pokemonEscolhido < 1 || pokemonEscolhido > lenpokedex ){
                      System.out.printf("%sOpção inválida!%s Verifique a quantidade de Pokemons que possui%n", cor.getVermelho(), cor.getReset());
                    }
                  }else{
                    System.out.printf("%sOpção inválida! Digite apenas números%s%n", cor.getVermelho(), cor.getReset());
                    escolha.next();
                    pokemonEscolhido = 0;
                  }
              } while (pokemonEscolhido < 1 || pokemonEscolhido > lenpokedex);

              //define o pokemon escolhilho para a batalha
              Pokemon escolhido = treinadorEscolhido.getPokedex().getPokemon(pokemonEscolhido - 1);

              //iniciar batalha
              Batalha batalha = new Batalha(escolhido,  alvo, treinadorEscolhido);
              //retorna um valor booleano para verificar se capturou o pokemon alvo
              boolean capturou = batalha.batalhar();
              
              //Se ele capturou, remove da lista de pokemons selvagens
              if(capturou){
                pokemonSelvagem.remove(alvo);  
                //se a lista de pokemons selvagens for 0, quer dizer que ele capturou todos e finaliza o jogo
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

              int escolhaAposBatalha;
              do{
                System.out.printf("%sSELEIONE UMA DAS OPÇÕES ABAIXO:%s \n1 - Batalhar Novamente\n2 - Ver Pokédex e batalhar\n3 - Sair\n ", cor.getAmarelo(), cor.getReset()); 
              System.out.println("-----------------------------------");
                if(escolha.hasNextInt()){
                  escolhaAposBatalha = escolha.nextInt();
                  if(escolhaAposBatalha != 1 && escolhaAposBatalha != 2 && escolhaAposBatalha != 3){
                    System.out.printf("%sOpção inválida!%s Digite 1, 2 ou 3%n", cor.getVermelho(), cor.getReset());
                  }
                } else{
                    System.out.printf("%sOpção inválida! Digite apenas números%s%n", cor.getVermelho(), cor.getReset());
                    escolha.next();
                    escolhaAposBatalha = 0;
                }
              }while (escolhaAposBatalha < 1 || escolhaAposBatalha > 3);
              
            
              System.out.println("opcao da escolha: " + escolhaAposBatalha);
              if (escolhaAposBatalha == 1){
                //batalhar novamente
              } else if (escolhaAposBatalha == 2){
                System.out.println("-----------------------------------");
                System.out.printf("%s Pokedex do(a) %s: %s%n", cor.getRosa(), treinadorEscolhido.getNome(), cor.getReset());

                int indice = 1;
                for (Pokemon pokemon : treinadorEscolhido.getPokedex().getlistaPokemons()) {
                    System.out.println(indice + " - " + pokemon);
                    indice++;
                    
                }
                System.out.println("-----------------------------------\n");

                System.out.println("Nome dos Ataques: ");
                //Para cada pokemon, mostrar o Ataque dele

                for (Pokemon pokemon : treinadorEscolhido.getPokedex().getlistaPokemons()) {
                System.out.printf("Ataque do seu Pokémon: ");
                pokemon.atacar();
                }
                System.out.println("-----------------------------------\n");

                System.out.printf(" %s Pokemons disponiveis para captura: %s\n ", cor.getRosa(), cor.getReset());
                 //Para cada pokemon, mostrar os disponiveis na lista pokemonSelvagem
                for (Pokemon pokemon : pokemonSelvagem) {
                  System.out.println("- " + pokemon.getNome());
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


