package edu.kit.kastel;

import java.util.ArrayList;
import java.util.List;
/*
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
 */

/**
 * The one and only class. Solves the problem entirely.
 *
 * @author uwwfh
 */
public final class OneAndOnly {

    private static final String NUMBER_SEPARATOR = " ";
    private static final int FILEPATH_INDEX = 0;
    private static final int TOTAL_SUM_INDEX = 0;

    private static final List<List<Integer>> HYPERROUTES = new ArrayList<>();
    private static int[] entryDegrees;
    private static int planetCount;

    private OneAndOnly() { }

    /**
     * The main entry point.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        List<String> filecontents = FileHelper.readAllLines(args[FILEPATH_INDEX]);
        planetCount = Integer.parseInt(filecontents.get(TOTAL_SUM_INDEX));
        entryDegrees = new int[planetCount];
        for (int i = 1; i <= planetCount; ++i) {
            String[] numbers = filecontents.get(i).split(NUMBER_SEPARATOR);
            int routeCount = Integer.parseInt(numbers[TOTAL_SUM_INDEX]);
            List<Integer> planetRoutes = new ArrayList<>();
            for (int j = 0; j < routeCount; ++j) {
                int targetPlanet = Integer.parseInt(numbers[j + 1]);
                planetRoutes.add(targetPlanet);
                ++entryDegrees[targetPlanet];
            }
            HYPERROUTES.add(planetRoutes);
        }
        System.out.println(getMinDroidCount());
    }

    private static int getMinDroidCount() {
        int droids = 0;
        for (int i : entryDegrees) {
            if (i == 0) {
                droids++;
            }
        }
        return droids;
        /*
        List<Integer> remainingPlanets = new ArrayList<>();
        for (int i = 0; i < planetCount; ++i) {
            remainingPlanets.add(i);
        }
        // Sort by entry degrees.
        remainingPlanets.sort(Comparator.comparingInt(planet -> ENTRY_DEGREES[planet]));
        // In theory, everything with entry degree >= 1 will be reached by something else, so we really just need to
        // loop through all with entry degree == 0.

        while (!remainingPlanets.isEmpty()) {
            // Choose a new start planet
            int startPlanet = remainingPlanets.get(0);
            //remainingPlanets.remove((Object) startPlanet);
            //Queue<Integer> placesIWantToSee = new LinkedList<>(HYPERROUTES.get(startPlanet));
            Queue<Integer> placesIWantToSee = new LinkedList<>();
            placesIWantToSee.add(startPlanet);
            System.out.println("Starting with planet " + startPlanet);
            while (!placesIWantToSee.isEmpty()) {
                int newPlanet = placesIWantToSee.poll();
                // Todo debug
                System.out.println("Attempting to remove planet with id %d, success will be: %s"
                    .formatted(newPlanet, placesIWantToSee.contains((Object) newPlanet)));
                // This cast to object is necessary because otherwise we're calling
                // list.remove(index), which is a) not what we want and b) returns a T, not a boolean.
                if (remainingPlanets.remove((Object) newPlanet)) {
                    // We haven't visited before
                    // Enqueue all objects. If we've seen them before, we won't end up when they're dequeued.
                    List<Integer> routes = HYPERROUTES.get(startPlanet);
                    placesIWantToSee.addAll(routes);
                    // Todo debug
                    for (int i : routes) System.out.println("Encountered Planet %d, will be removing it shortly".formatted(i));
                }
            }
            // We have visited this entire graph. Now we add the 1 droid that will explore it.
            droids++;
        }
        return droids;
         */
    }
}
