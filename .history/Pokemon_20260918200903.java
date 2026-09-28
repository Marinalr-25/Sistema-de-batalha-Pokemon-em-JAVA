public class Pokemon{
    private String nome;
    private String tipo;
    private int nivel;
    private int hp;
    private int ataquebase;
    
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
        this.nivel = nivel;
    }
    public int gethp(){
        return hp;
    }
    public void sethp(int hp){
        this.hp = hp;
    }

    public int getataquebase(){
        return ataquebase;
    }
    public void setataquebase(int ataquebase){
        this.ataquebase = ataquebase;
    }
    public Pokemon(String nome, String tipo, int nivel, int hp, int ataquebase){
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
        this.hp = hp;
        this.ataquebase = ataquebase;
        
    }
    void atacar(){

    }
    void defender(){
    
    }
    void receberDano(){

    }
    void estaDerrotado(){

    }
}
