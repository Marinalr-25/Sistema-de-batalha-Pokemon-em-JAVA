public class PokemonFogo extends Pokemon {
  Cores cor = new Cores();
    public PokemonFogo(String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Fogo",nivel,hp,ataquebase, speed);
    }
    
    @Override
    public void atacar(){
        System.out.printf("%s%s%s atacou com chamas intensas!%n", cor.getVermelho(), getnome(), cor.getReset());
    }

        public void ataqueChamas() {
        System.out.printf(
            "%s%s%s finalizou o oponente com Chamas Finais!%n",
            cor.getVermelho(),
            getnome(),
            cor.getReset()
        );
      } 
}
