public class PokemonAgua extends Pokemon {
  Cores cor = new Cores();
    public PokemonAgua(String nome, int nivel, int hp, int ataquebase, int speed ){
        super(nome,"Agua", nivel,hp,ataquebase, speed);
    }

    
    @Override
    public void atacar(){
        System.out.printf("%s%s%s disparou uma onda gigantesca!%n", cor.getAzul(), getnome(), cor.getReset());
    }
        //instaceof + downcasting
        public void ataqueChamas() {
        System.out.printf(
            "%s%s finalizou o oponente com Chamas Finais!%s%n",
            cor.getVermelho(),
            getnome(),
            cor.getReset()
        );
      } 


}

//porque brasa é uma referência do tipo Pokemon, e Pokemon não possui ataqueChamas()
    //     Calcula o dano
    //       ↓
    // Dano mata o alvo?
    //    ↙       ↘
    //  NÃO       SIM
    //  ↓          ↓
    // atacar()   instanceof
    //             ↓
    //         downcasting
    //             ↓
    //        ataqueChamas()