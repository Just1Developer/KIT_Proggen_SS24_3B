package edu.kit.kastel;

import java.util.ArrayList;
import java.util.List;

/**
 * The one and only class. Solves the problem entirely.
 * Please see the readme.md for a brief explanation of how and why this works.
 *
 * @author uwwfh
 */
public final class OneAndOnly {

    private static final String NUMBER_SEPARATOR = " ";
    private static final int FILEPATH_INDEX = 0;
    private static final int TOTAL_SUM_INDEX = 0;

    private OneAndOnly() { }

    /**
     * The main entry point.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        List<String> fileContents = FileHelper.readAllLines(args[FILEPATH_INDEX]);
        int planetCount = Integer.parseInt(fileContents.get(TOTAL_SUM_INDEX));
        List<Integer> startPoints = new ArrayList<>();
        for (int i = 0; i < planetCount; ++i) {
            startPoints.add(i);
        }

        for (int i = 1; i <= planetCount; ++i) {
            String[] numbers = fileContents.get(i).split(NUMBER_SEPARATOR);
            int routeCount = Integer.parseInt(numbers[TOTAL_SUM_INDEX]);
            for (int j = 0; j < routeCount; ++j) {
                int targetPlanet = Integer.parseInt(numbers[j + 1]);
                // This cast to object is necessary because otherwise we're calling
                // list.remove(index), which is a) not what we want and b) returns a T, not a boolean.
                startPoints.remove((Object) targetPlanet);
            }
        }

        // Droid count = number of points no planet links to = number of remaining start points
        System.out.println(startPoints.size());
    }
}
