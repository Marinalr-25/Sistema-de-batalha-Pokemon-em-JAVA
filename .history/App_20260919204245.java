import java.util.Scanner;


public class App{
    public static void main (String[]args){
      PokemonAgua poseidon= new PokemonAgua("Poseidon","Agua",1,100,20);
      PokemonEletricidade thor= new PokemonEletricidade("Thor","Eletrico",1,100,20);
      PokemonFogo raiva= new PokemonFogo("Raiva","Fogo",1,100,20);
      PokemonTerra tarzan= new PokemonTerra("Tarzan","Terra",1,100,20);
      PokemonVento furacao= new PokemonVento("Furacão","Vento",1,100,20);
      PokemonVento joaozinho= new PokemonVento("Joaozinho","Fogo",1,100,10);
      PokemonVento mariazinha= new PokemonVento("Mariazinha","Terra",1,100,15);
      PokemonVento mariazinh2= new PokemonTerra("Mariazinha","Terra",0,100,15);

      //azul - poseidon - 34
      //raiva - vermelho - 31
      //thor - amarelo - 33
      // tarzan - verde - 32
      //furacao = roxo - 35
        System.out.println("=".repeat(30));
        System.out.println("\033[1m\033[93m=== JOGO DO POKÉMON ===\033[0m");
        System.out.println("=".repeat(30));
        Scanner escolha = new Scanner(System.in);
        System.out.print("\n1 - Capturar\n2 - Pokédex\n3 - Batalhar\n4 - Sair\nSELEIONE UMA DAS OPÇÕES ACIMA: "); //input para perguntar a escolha
        int menu = escolha.nextInt();

        if(menu==1){
            System.out.println("\nVocê selecionou a opção Capturar");
        }
        else if(menu==2){
            System.out.println("\nVocê selecionou a opção Pokédex");

        }
        else if(menu==3){
            System.out.println("\nVocê selecionou a opção Batalhar");
            Batalha batalha = new Batalha( joaozinho, mariazinha);
            batalha.batalhar();
            
        }
        else if(menu==4){
            System.out.println("\nVocê selecionou a opção Sair");

        }
        else{
            System.out.println("\nOpcão inválida");
        }

        escolha.close();
        // poseidon.defender();
        // poseidon.dormir();

        // thor.atacar();
        // thor.defender();
        // thor.dormir();

        // raiva.atacar();
        // raiva.defender();
        // raiva.dormir();
      
        // tarzan.atacar();
        // tarzan.defender();
        // tarzan.dormir();

        // furacao.atacar();
        // furacao.defender();
        // furacao.dormir();

        
        
        
        
    }

    
    

    
}


