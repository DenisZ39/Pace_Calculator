import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class History {
    private final List<Race> races;

    public History() {
        this.races = new ArrayList<>();
    }

    public History(List<Race> initialRaces) {
        this.races = new ArrayList<>(initialRaces);
    }

    public void add(Race race) {
        if (race != null) {
            races.add(race);
        }
    }

    public boolean isEmpty() {
        return races.isEmpty();
    }

    public List<Race> getRaces() {
        return Collections.unmodifiableList(races);
    }

    public double getTotalDistance() {
        double total = 0;
        for (Race race : races) {
            total += race.getDistanceKm();
        }
        return total;
    }

    public Optional<Race> getBestPaceRace() {
        if (races.isEmpty()) {
            return Optional.empty();
        }

        Race best = races.get(0);
        for (int i = 1; i < races.size(); i++) {
            Race current = races.get(i);
            if (current.getPaceSecondsPerKm() < best.getPaceSecondsPerKm()) {
                best = current;
            }
        }
        return Optional.of(best);
    }

    public Optional<Race> getLongestRun() {
        if (races.isEmpty()) {
            return Optional.empty();
        }

        Race longest = races.get(0);
        for (int i = 1; i < races.size(); i++) {
            Race current = races.get(i);
            if (current.getDistanceKm() > longest.getDistanceKm()
                    || (Float.compare(current.getDistanceKm(), longest.getDistanceKm()) == 0
                    && current.getTotalSeconds() < longest.getTotalSeconds())) {
                longest = current;
            }
        }
        return Optional.of(longest);
    }
}
