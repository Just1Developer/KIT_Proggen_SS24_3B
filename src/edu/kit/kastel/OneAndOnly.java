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
        // Read file contents
        List<String> fileContents = FileHelper.readAllLines(args[FILEPATH_INDEX]);
        // Get the number of planets by parsing the first line to an integer
        int planetCount = Integer.parseInt(fileContents.get(TOTAL_SUM_INDEX));
        // Make the start points. At the beginning, every planet (0 - count-1) is a start point
        // This number will be reduced shortly
        List<Integer> startPoints = new ArrayList<>();
        for (int i = 0; i < planetCount; ++i) {
            startPoints.add(i);
        }

        // Read lines planetCount lines, but go from 1 - count instead of 0 - count-1
        // to align with the index, the 0th line was the number of planets, remember?
        for (int i = 1; i <= planetCount; ++i) {
            // Get all numbers, the first number is the route count
            String[] numbers = fileContents.get(i).split(NUMBER_SEPARATOR);
            int routeCount = Integer.parseInt(numbers[TOTAL_SUM_INDEX]);
            // Same thing with the 1-indexing here. Remove every planet that we link to here, since that
            // planet won't have entry degree of 0 anymore, since, you know, we're connecting to it.
            for (int j = 1; j <= routeCount; ++j) {
                int targetPlanet = Integer.parseInt(numbers[j]);
                // This cast to object is necessary because otherwise we're calling
                // list.remove(index), which is a) not what we want and b) returns a T, not a boolean.
                startPoints.remove((Object) targetPlanet);
            }
        }

        // Droid count = number of points no planet links to = number of remaining start points
        // Done.
        System.out.println(startPoints.size());
    }
}
