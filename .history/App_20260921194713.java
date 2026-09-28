import java.util.Scanner;


public class App{
    public static void main (String[]args){
      Cores cor = new Cores();
      PokemonAgua poseidon= new PokemonAgua("Poseidon",1,135,15);
      PokemonFogo raiva= new PokemonFogo("Raiva",1,110,25);
      PokemonAr furacao= new PokemonAr("Furacão",1,100,20);
      PokemonTerra tarzan= new PokemonTerra("Tarzan",1,100,20);
      PokemonEletricidade thor= new PokemonEletricidade("Thor",1,100,20);

        System.out.println("=".repeat(30));
        System.out.println(cor.getAmarelo()+ cor.getNegrito() + "=== JOGO DO POKÉMON ===" + cor.getReset());
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
            Batalha lucas = new Batalha(poseidon, raiva);
            lucas.batalhar();            
        }
        else if(menu==4){
            System.out.println("\nVocê saiu da batalha");
        }
        else{
            System.out.println("\nOpcão inválida");
        }
        escolha.close();
    }
}


