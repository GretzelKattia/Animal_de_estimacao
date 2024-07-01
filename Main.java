import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        String mensagemInicial = "Olá! Seja bem-vindo ao Simulador de Animal de Estimação Virtual!\nDigite o nome do seu animal de estimação:";
        String nomePet = JOptionPane.showInputDialog(null, mensagemInicial,
                "Oi amigo!", JOptionPane.INFORMATION_MESSAGE);

        while (nomePet == null || nomePet.isEmpty() || nomePet.strip() == ""){
            nomePet = JOptionPane.showInputDialog(null, "Uau, qual o nome do seu pet?", "erro", JOptionPane.ERROR_MESSAGE);
        }

        nomePet = nomePet.strip();

        Pet pet = new Pet(nomePet);
        int dias = 0; // contador de dias

        while(true){
            String mensagemEscolha = "\n O que você deseja fazer? : \n 1. Alimentar " + nomePet + "\n 2. Brincar com " + nomePet + "\n 3. Verificar o status do Pet" + "\n 4. Deixar seu bixinho descansar!" + "\n 5. Sair do Virtual PET";

            String escolha = JOptionPane.showInputDialog(mensagemEscolha);
            if(escolha.isEmpty()){
                return;
            }
            char escolhaChar = escolha.charAt(0);

            switch (escolhaChar){
                case '1':
                    pet.alimentar();
                    break;
                case '2':
                    pet.brincar();
                    break;
                case '3':
                    pet.mostrarStatus();
                    break;
                case '4':
                    String horasDescanso = JOptionPane.showInputDialog("Por quantas horas " + nomePet + " vai descansar?");
                    int horas = Integer.parseInt(horasDescanso);
                    pet.descansar(horas);
                    break;
                case '5':
                    int confirmarSair = JOptionPane.showConfirmDialog(null, "Deseja realmente abandonar o seu bixinho virtual?", "Realmente deseja isso?", JOptionPane.OK_CANCEL_OPTION);
                    if (confirmarSair == 0){
                        JOptionPane.showMessageDialog(null, "Tchau tchau amiguinho. Nunca vou te esquecer :(");
                        return;
                    }
            }

            dias += 1; // incrementa o contador de dias
            if(dias == 7){
                JOptionPane.showMessageDialog(null, "Parabéns! Você cuidou do " + nomePet + " por uma semana. Você ganhou o jogo!");
                return;
            }

        }
    }
}
