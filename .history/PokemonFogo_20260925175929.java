public class PokemonFogo extends Pokemon {
  Cores cor = new Cores();
    public PokemonFogo(String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Fogo",nivel,hp,ataquebase, speed);
    }
    
    @Override
    public void atacar(){
        System.out.printf("%s%s%s atacou com chamas intensas!%n", cor.getVermelho(), getNome(), cor.getReset());
    }
        //instaceof + downcasting -> só pode acessar se o Pokemon for do tipo Agua
        public void ataqueChamasFinais() {
        System.out.printf(
            "%s%s finalizou o oponente com Chamas Finais!%s%n",
            cor.getVermelho(),
            getNome(),
            cor.getReset()
        );
      } 

    //metodo para subir de nivel. Definido um padrao para cada elemento
    @Override 
    public void subirNivel(){
      super.subirNivel();
      this.aumentarAtaque(3);
      System.out.printf("%s%s subiu de nível!%s%n Nível: %d | Ataque Base: %d%n", cor.getVerde(), getNome(), cor.getReset(), getNivel(), getAtaquebase());
      }
}
