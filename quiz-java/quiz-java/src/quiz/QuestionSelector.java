package quiz;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionSelector {
    public QuestionSelector() {}


    public String[][] selectRandomQuestions(String[][] questionsArray, int numQuestions) {
        List<Integer> chosenIndexes = new ArrayList<>();
        Random random = new Random();
        int totalQuestions = questionsArray.length;

        while (chosenIndexes.size() < 5) {
            int randomIndex = random.nextInt(totalQuestions);
            if (!chosenIndexes.contains(randomIndex)) {
                chosenIndexes.add(randomIndex);
            }
        }

        String[][] chosenQuestions = new String[5][5];
        for (int i = 0; i < numQuestions; i++) {
            chosenQuestions[i] = questionsArray[chosenIndexes.get(i)];
        }

        return chosenQuestions;
    }

}
