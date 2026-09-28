public class Pokemon{
    private String nome;
    private String tipo;
    private int nivel;
    private int hp;
    private int ataquebase;
    private int speed;
    
    public String getnome(){
        return nome;
    }
    public void setnome(String nome){
        this.nome = nome;
    }
    public String gettipo(){
        return tipo;
    }
    public void settipo(String tipo){
        this.tipo = tipo;
    }
    public int getnivel(){
        return nivel;
    }
    public void setnivel(int nivel){
      if (nivel > 0){
        this.nivel = nivel;
      }
    }
    public int gethp(){
        return hp;
    }
    public void sethp(int hp){
      if (hp >= 0){
        this.hp = hp;
      }
    }

    public int getataquebase(){
        return ataquebase;
    }
    public void setataquebase(int ataquebase){
        this.ataquebase = ataquebase;
    }
    public int getspeed(){
        return speed;
    }
    public void setspeed(int speed){
        this.speed = speed;
    }

    //PokemonAgua poseidon= new PokemonAgua("Poseidon",1,135,15);
    public Pokemon(String nome, String tipo, int nivel, int hp, int ataquebase, int speed){
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
        this.hp = hp;
        this.ataquebase = ataquebase;
        this.speed = speed;
        
    }

    
    @Override
    public String toString() {
        return "nome" + nome + " | Tipo: " + tipo + " | Nível: " + nivel  +  " | HP: " + hp + " | Ataque Base " + ataquebase + " | Speed: " + speed;
    }
    void atacar(){
    }
    // void defender(){
    // }

    void receberDano(int dano){
      int novoHp = hp - dano;
      if (novoHp < 0){
        novoHp = 0;
      }
      sethp(novoHp);
    }
    boolean estaDerrotado(){
      if (hp <= 0){
        return true;
      } else{
        return false;
      }
    }
}
