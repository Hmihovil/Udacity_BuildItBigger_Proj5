package com.ramyhelow.jokelibrary;

import java.util.ArrayList;
import java.util.Random;

public class JokeFactory {
    private ArrayList<String> jokeList;
    private Random random;


    public JokeFactory() {
        jokeList = new ArrayList<>();
        random = new Random();
        jokeList.add("What’s the difference between a good joke and a bad joke timing.");
        jokeList.add("I woke up this morning and forgot which side the sun rises from, then it dawned on me.");
        jokeList.add("Velcro – what a rip-off!");
        jokeList.add("I hate Russian dolls, they’re so full of themselves.");
        jokeList.add("The best thing about good old days is that we were neither good nor old.");
        jokeList.add("Do I lose when the police officer says papers and I say scissors?");
    }

    public ArrayList<String> getJokeList() {
        return jokeList;
    }

    public String getRandomJoke() {
        return jokeList.get(random.nextInt(jokeList.size() + 1));
    }
}
