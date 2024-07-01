import javax.swing.JOptionPane;

public class Pet {
    private String nome;
    private int fome = 50;
    private int felicidade = 50;
    private int cansaco = 0;
    private int idade = 0; // novo atributo
    private int vontadeBanheiro = 0; // novo atributo
    private int sujeira = 0; // novo atributo


    public Pet(String name) {
        this.nome = name;
    }

    /**
     * getters
     * */
    public void mostrarStatus(){
        String message = "Status atual de " + nome + ";\n" + "Idade: " + idade + "\n Nível de fome: " + fome + "\n Nível de felicidade: " + felicidade + "\n Nível de cansaço: " + cansaco + "\n Vontade de ir ao banheiro: " + vontadeBanheiro + "\n Nível de sujeira: " + sujeira;; // atualizado;
        JOptionPane.showMessageDialog(null, message);
    }

    public int mostrarNivelDeFome(){
        return this.fome;
    }

    public int mostrarNivelDeFelicidade(){
        return this.felicidade;
    }

    public String mostrarNome(){
        return this.nome;
    }

    public int mostrarIdade(){ // novo getter para a idade
        return this.idade;
    }

    /**
     * setters
     * */
    public void alimentar(){
        fome -= 10;
        if(fome < 0) fome = 0;
        vontadeBanheiro += 10; // aumenta a vontade de ir ao banheiro quando o bichinho se alimenta
        JOptionPane.showMessageDialog(null, nome + " foi alimentado. O nível de fome diminuiu");
    }

    public void brincar(){
        if(cansaco >= 100){
            JOptionPane.showMessageDialog(null, "Seu bixinho está muito cansado para brincar!");
        }
        else{
            felicidade += 10;
            if(felicidade > 100) felicidade = 100;
            cansaco += 10;
            sujeira += 10; // aumenta a sujeira quando o bichinho brinca
            JOptionPane.showMessageDialog(null, nome + " está brincando e se sentindo mais feliz");
        }
    }

    public void descansar(int horas){
        this.cansaco -= horas * 12.5; // cada hora de descanso reduz o cansaço em 12.5
        if(this.cansaco < 0) this.cansaco = 0;
        JOptionPane.showMessageDialog(null, nome + " descansou por " + horas + " horas e está descansado!");
    }

    public void passarTempo() {
        fome += 5;
        felicidade -= 5;
        cansaco += 10;
        idade += 1;
        
        if(fome > 100){
            JOptionPane.showMessageDialog(null, nome + " chegou ao nível 100 de fome. Você perdeu o jogo.");
            System.exit(0);
        }

        if(felicidade < 0){
            JOptionPane.showMessageDialog(null, nome + " chegou ao nível zero de felicidade. Você perdeu o jogo.");
            System.exit(0);
        }

        if(vontadeBanheiro > 100 || sujeira > 100){
            JOptionPane.showMessageDialog(null, nome + " chegou ao nível limite de vontade de ir ao banheiro ou de sujeira. Você perdeu o jogo.");
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null, nome + " está ficando mais faminto com o passar do tempo.");
    }
}
