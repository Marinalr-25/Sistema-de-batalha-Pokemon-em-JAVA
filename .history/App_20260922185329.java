import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class App{
    public static void main (String[]args){
      Cores cor = new Cores();
      PokemonAgua poseidon= new PokemonAgua("Poseidon",1,135,15, 200);
      PokemonFogo raiva= new PokemonFogo("Raiva",1,110,25, 210);
      PokemonAr furacao= new PokemonAr("Furacão",1,100,20, 220);
      PokemonTerra tarzan= new PokemonTerra("Tarzan",1,100,20, 210);
      PokemonEletricidade thor= new PokemonEletricidade("Thor",1,100,20, 200);

      //Crie uma lista chamada pokemonSelvagem que vai guardar objetos do tipo Pokemon."
      ArrayList<Pokemon> pokemonSelvagem = new ArrayList<>();
      pokemonSelvagem.add(poseidon);
      pokemonSelvagem.add(raiva);
      pokemonSelvagem.add(furacao);
      pokemonSelvagem.add(tarzan);
      pokemonSelvagem.add(thor);
      
      

      Random random5 = new Random();
      Treinador treinadorVictor = new Treinador("Victor");
      

        System.out.println("=".repeat(30));
        System.out.println(cor.getAmarelo()+ cor.getNegrito() + "=== JOGO DO POKÉMON ===" + cor.getReset());
        System.out.println("=".repeat(30));
        Scanner escolha = new Scanner(System.in);
        System.out.print("\n1 - Capturar\n2 - Pokédex\n3 - Batalhar\n4 - Sair\nSELEIONE UMA DAS OPÇÕES ACIMA: "); 
        int menu = escolha.nextInt();

        if(menu==1){
            System.out.println("\nVocê selecionou a opção Capturar");
            
        }
        else if(menu==2){
            System.out.println("\nVocê selecionou a opção Pokédex");
        }
        else if(menu==3){
            System.out.println("\nVocê selecionou a opção Batalhar");
            //dano = random.nextInt(11) + 15;    // 10-25
            //poseidon = 0
            //raiva = 1
            // furacao = 2
            // tarzan = 3
            // thor = 4

            int oponente = random5.nextInt(6); //0 - 4
            int lenPokemonSelvagem = pokemonSelvagem.size();
            Pokemon alvo = pokemonSelvagem.get(lenPokemonSelvagem);
            System.out.println("nome oponenete: " + alvo.getnome());
            System.out.println("tamanho lista " + lenPokemonSelvagem);
            
            System.out.println("numero sorteado: " + oponente);
            Batalha batalha = new Batalha(poseidon, thor, treinadorVictor);
            batalha.batalhar();            
        }
        else if(menu==4){
            System.out.println("\nVocê saiu do jogo");
        }
        else{
            System.out.println("\nOpcão inválida");
        }
        escolha.close();
    }
}


