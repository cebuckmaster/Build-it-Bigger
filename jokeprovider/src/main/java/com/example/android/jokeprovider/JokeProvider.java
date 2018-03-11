package com.example.android.jokeprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is a Java Library that provides hilarious Jokes based on a random number between 0 and 10
 */

public class JokeProvider {


    public String getJoke() {

        int randomJokeNumber = randInt(0, 10);

        String jokeQuestion = getJokeQuestion(randomJokeNumber);
        String jokeAnswer = getJokeAnswer(randomJokeNumber);

        return jokeQuestion+", "+jokeAnswer;

    }


    public String getJokeQuestion(int jokeNum) {

        if (jokeNum > 10) {
            return "What do you call a cow with no legs?";
        }

        List<String> jokeQuestions = new ArrayList<String>();

        jokeQuestions.add("How do all the oceans say hello to each other?");
        jokeQuestions.add("What did one wall say to the other wall?");
        jokeQuestions.add("What do you call a bear with no teeth?");
        jokeQuestions.add("What do you call cheese that isn't yours?");
        jokeQuestions.add("Where do cows go for entertainment?");
        jokeQuestions.add("How do you know if there's an elephant under your bed?");
        jokeQuestions.add("Why are elephants so wrinkled?");
        jokeQuestions.add("How do you keep an elephant from charging?");
        jokeQuestions.add("Why did the elephant paint himself different colors?");
        jokeQuestions.add("How can you tell if an elephant has been in your refrigerator?");
        jokeQuestions.add("What is the difference between elephants and grapes?");

        return jokeQuestions.get(jokeNum);
    }
    public String getJokeAnswer(int jokeNum) {

        if (jokeNum > 10) {
            return "Ground Beef!";
        }

        List<String> jokeAnswers = new ArrayList<String>();

        jokeAnswers.add("They wave!!");
        jokeAnswers.add("I'll meet you at the corner");
        jokeAnswers.add("A gummy bear!");
        jokeAnswers.add("Nacho cheese!!!");
        jokeAnswers.add("To the Moo-vies");
        jokeAnswers.add("Your head hits the ceiling");
        jokeAnswers.add("Because they take too long to iron!");
        jokeAnswers.add("Take away her credit card!");
        jokeAnswers.add("So he could hide in the crayon box!");
        jokeAnswers.add("By the footprints in the butter!");
        jokeAnswers.add("Grapes are purple");

        return jokeAnswers.get(jokeNum);


    }

    public static int randInt(int min, int max) {

        Random rand = new Random();

        return rand.nextInt((max - min) + 1) + min;

    }

}
