package com.ramyhelow.jokelibrary;

import java.util.ArrayList;
import java.util.Random;

public final class JokeFactory {
    private ArrayList<String> jokeList;
    private Random random;


    public JokeFactory() {
        jokeList = new ArrayList<>();
        random = new Random();
        jokeList.add("What’s the difference between a good joke and a bad joke timing.");
        jokeList.add("Q: How many programmers does it take to screw in a light bulb?\n" +
                "\n" +
                "A: None. It's a hardware problem.");
        jokeList.add("I woke up this morning and forgot which side the sun rises from, then it dawned on me.");
        jokeList.add("Definition, Programmer: An organism that turns caffeine and pizza into software.");
        jokeList.add("Velcro – what a rip-off!");
        jokeList.add("Software developers like to solve problems. If there are no problems available, they will create their own problems. It’s an addiction");
        jokeList.add("I hate Russian dolls, they’re so full of themselves.");
        jokeList.add("Definition, Algorithm: Word used by programmers when they do not want to explain what they did.");
        jokeList.add("The best thing about good old days is that we were neither good nor old.");
        jokeList.add("An optimist says: “the glass is half full.”\n" +
                "\n" +
                "A pessimist says: “the glass is half empty.”\n" +
                "\n" +
                "A programmer says: “the glass is twice as large as necessary.”");
        jokeList.add("Do I lose when the police officer says papers and I say scissors?");
        jokeList.add("I'd like to make the world a better place, but they won't give me the source code...");
        jokeList.add("A programmer puts two glasses on his bedside table before going to sleep. A full one, in case he gets thirsty, and an empty one, in case he doesn’t.");
        jokeList.add("Java and C were telling jokes. It was C's turn, so he writes something on the wall, points to it and says \"Do you get the reference?\" But Java didn't.");
    }

    public ArrayList<String> getJokeList() {
        return jokeList;
    }

    public String getRandomJoke() {
        return jokeList.get(random.nextInt(jokeList.size() + 1));
    }
}
