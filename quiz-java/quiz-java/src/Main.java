import models.Pergunta;
import quiz.QuestionSelector;
import texto.util.ReadFile;
import java.util.Calendar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Pergunta> perguntas = new ArrayList<>();
        ReadFile rf = new ReadFile();
        String[][] questionsArray = rf.readFile("perguntas.txt");
        QuestionSelector questionSelector = new QuestionSelector();
        String[][] chosenQuestions = questionSelector.selectRandomQuestions(questionsArray, 5);

        int pesoPergunta = 1;
        for (String[] value : chosenQuestions) {
            Pergunta pergunta = new Pergunta();
            pergunta.inertQuestion(value, pesoPergunta);
            perguntas.add(pergunta);
            pesoPergunta++;
        }

        int totalScore = 0;
        int numRightAnswers = 0;
        List<Pergunta> perguntasCertas = new ArrayList<>();
        List<Pergunta> perguntasErradas = new ArrayList<>();
        List<String> respostasCorretas = new ArrayList<>();

        System.out.println("\nBem vindo ao Quiz do time C! \nA seguir voce ira responder 5 perguntas e recebera sua pontuacao maxima de 15 pontos.\n");
        System.out.println("====================================INICIO=======================================\n");

        Calendar inicio = Calendar.getInstance();

        for (Pergunta p : perguntas) {
            if(p.getPesoPergunta() == 1){
              System.out.println("Pergunta " + p.getPesoPergunta() + ": " + p.getPesoPergunta() + " ponto");
            }else {
              System.out.println("Pergunta " + p.getPesoPergunta() + ": " + p.getPesoPergunta() + " pontos");
            }
            System.out.println("Enunciado: " + p.getEnunciado() + "\n");
            System.out.println("Opcao a: " + p.getOpcao1());
            System.out.println("Opcao b: " + p.getOpcao2());
            System.out.println("Opcao c: " + p.getOpcao3());
            System.out.println("Opcao d: " + p.getOpcao4() + "\n");

            String answer;
            boolean isValid = false;
            while (!isValid) {
                System.out.println("Insira sua resposta: (a, b, c ou d)");
                answer = sc.nextLine().toLowerCase();
                isValid = isValidAnswer(answer);

                if (!isValid) {
                    System.out.println("Resposta invalida. Por favor, insira novamente.");
                } else {
                    System.out.println("\n<------------------------------------->\n");
                    if (answer.charAt(0) == p.getResposta().charAt(0)) {
                        totalScore += p.getPesoPergunta();
                        numRightAnswers++;
                        perguntasCertas.add(p);
                    } else {
                        perguntasErradas.add(p);
                        respostasCorretas.add(p.getResposta());
                    }
                }

            }
        }

        System.out.println("\n<===================Resultado=====================>");

        System.out.println("\nRespostas corretas:");
        for (Pergunta p : perguntasCertas) {
            System.out.println("\nPergunta " + p.getPesoPergunta() + ": " + p.getEnunciado());
        }

        System.out.println("\n<=================================================>");

        System.out.println("\nRespostas incorretas:\n");
        for (int i = 0; i < perguntasErradas.size(); i++) {
            Pergunta p = perguntasErradas.get(i);
            System.out.println("Pergunta " + p.getPesoPergunta() + ": " + p.getEnunciado());
            System.out.println("Resposta correta: " + respostasCorretas.get(i));
            System.out.println();
        }

        System.out.println("<===================PONTUACAO=====================>");

        Calendar fim = Calendar.getInstance();

        long inicioMillis = inicio.getTimeInMillis();
        long fimMillis = fim.getTimeInMillis();
        long totalMillis = fimMillis - inicioMillis;

        long  toalSeconds = totalMillis / 1000;


        System.out.println("\nVoce acertou: " + numRightAnswers + " perguntas.");
        System.out.println("Sua pontuacao total foi: " + totalScore + "/15" );
        System.out.println("Seu tempo foi de " + toalSeconds + " segundos");


        System.out.println("\n<====================FIM==========================>");



    }

    public static boolean isValidAnswer(String answer) {
        char[] answers = {'a', 'b', 'c', 'd'};
        if (answer.length() == 1) {
            for (char value : answers) {
                if (answer.charAt(0) == value) {
                    return true;
                }
            }
        }
        return false;
    }
}
