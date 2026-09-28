public class PokemonEletricidade extends Pokemon{
    public PokemonEletricidade(String nome, int nivel, int hp, int ataquebase ){
        super(nome,"Elétrico",nivel,hp,ataquebase);
    }
    @Override
    public void atacar(){
        System.out.println(getnome() + " lançou uma super choque!");
    }

}
