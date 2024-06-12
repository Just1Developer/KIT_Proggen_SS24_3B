package edu.kit.kastel;

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

    private static boolean[] hasEntryPoints;

    private OneAndOnly() { }

    /**
     * The main entry point.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        List<String> filecontents = FileHelper.readAllLines(args[FILEPATH_INDEX]);
        int planetCount = Integer.parseInt(filecontents.get(TOTAL_SUM_INDEX));
        hasEntryPoints = new boolean[planetCount];

        for (int i = 1; i <= planetCount; ++i) {
            String[] numbers = filecontents.get(i).split(NUMBER_SEPARATOR);
            int routeCount = Integer.parseInt(numbers[TOTAL_SUM_INDEX]);
            for (int j = 0; j < routeCount; ++j) {
                int targetPlanet = Integer.parseInt(numbers[j + 1]);
                hasEntryPoints[targetPlanet] = true;
            }
        }
        System.out.println(getMinDroidCount());
    }

    private static int getMinDroidCount() {
        int droids = 0;
        for (boolean hasEntries : hasEntryPoints) {
            if (!hasEntries) {
                ++droids;
            }
        }
        return droids;
    }
}
