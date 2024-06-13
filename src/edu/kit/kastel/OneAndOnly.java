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

    private OneAndOnly() { }

    /**
     * The main entry point and sole method of this program.<br/>
     * <br/>
     * Solution is in O(n*m) time, where n = number of planets and m = number of hyperroutes per planet.<br/>
     * This time estimate includes processing the file contents, but not implicit array initialization
     * or reading the file contents from the hard drive.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Read file contents
        final List<String> fileContents = FileHelper.readAllLines(args[FILEPATH_INDEX]);
        // Get the number of planets by parsing the first line to an integer
        final int planetCount = Integer.parseInt(fileContents.get(TOTAL_SUM_INDEX));
        // Make the start points. At the beginning, every planet (0 - count-1) is a start point
        // Since the default value is 'false', we use that as '= is a start planet'
        boolean[] hasInputHyperroutes = new boolean[planetCount];
        // We're doing a mix of array and lists, since list remove time isn't that good, and we'd only
        // need to property 'size', we're just keeping track of removals and the list size.
        int druidStartPlanets = planetCount;

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
                if (!hasInputHyperroutes[targetPlanet]) {
                    // Note that this now has >= 1 incoming hyperroutes instead of 0.
                    // So, we lose a possible start planet.
                    hasInputHyperroutes[targetPlanet] = true;
                    druidStartPlanets--;
                }
            }
        }

        // See how many start planets remain.
        System.out.println(druidStartPlanets);
    }
}
