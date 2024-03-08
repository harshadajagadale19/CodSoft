package bcs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    String question;
    List<String> options;
    int correctAnswer;

    QuizQuestion(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class QuizApplication {
    private static List<QuizQuestion> quizQuestions = new ArrayList<>();
    private static int userScore = 0;

    public static void main(String[] args) {
        initializeQuiz();
        startQuiz();
    }

    private static void initializeQuiz() {
        
        quizQuestions.add(new QuizQuestion("What is the capital of France?", List.of("A. Berlin", "B. London", "C. Paris"), 2));
       
    }

    private static void startQuiz() {
        for (QuizQuestion question : quizQuestions) {
            displayQuestion(question);
            startTimer(question);
            int userAnswer = getUserAnswer();
            checkAnswer(question, userAnswer);
        }

        displayResult();
    }

    private static void displayQuestion(QuizQuestion question) {
        System.out.println(question.question);
        for (String option : question.options) {
            System.out.println(option);
        }
    }

    private static void startTimer(QuizQuestion question) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            
            public void run() {
                System.out.println("Time's up! Moving to the next question.");
                timer.cancel();
            }
        }, 10000); 
    }

    private static int getUserAnswer() {
        System.out.println("Enter the number of your answer:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void checkAnswer(QuizQuestion question, int userAnswer) {
        if (userAnswer == question.correctAnswer) {
            System.out.println("Correct!");
            userScore++;
        } else {
            System.out.println("Incorrect. The correct answer is: " + question.options.get(question.correctAnswer - 1));
        }
        System.out.println("Your current score: " + userScore);
        System.out.println("-----------------------------");
    }

    private static void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your final score: " + userScore);
        
    }
}