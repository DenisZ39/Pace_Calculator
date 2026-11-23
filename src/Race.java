import java.util.Locale;

public class Race {
    private final float distanceKm;
    private final int hours;
    private final int minutes;
    private final int seconds;

    public Race(float distanceKm, int hours, int minutes, int seconds) {
        if (distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be greater than 0.");
        }
        if (hours < 0 || minutes < 0 || seconds < 0) {
            throw new IllegalArgumentException("Time values cannot be negative.");
        }
        int totalSeconds = hours * 3600 + minutes * 60 + seconds;
        if (totalSeconds <= 0) {
            throw new IllegalArgumentException("Total time must be greater than 00:00:00.");
        }

        this.distanceKm = distanceKm;
        this.hours = totalSeconds / 3600;
        this.minutes = (totalSeconds % 3600) / 60;
        this.seconds = totalSeconds % 60;
    }

    public float getDistanceKm() {
        return distanceKm;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getTotalSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    public double getPaceSecondsPerKm() {
        return getTotalSeconds() / (double) distanceKm;
    }

    public String getFormattedPace() {
        int paceSeconds = (int) Math.round(getPaceSecondsPerKm());
        int paceMinutes = paceSeconds / 60;
        int remainingSeconds = paceSeconds % 60;
        return String.format(Locale.US, "%02d:%02d min/km", paceMinutes, remainingSeconds);
    }

    public String getFormattedTime() {
        return String.format(Locale.US, "%02d:%02d:%02d", hours, minutes, seconds);
    }

    public String toCsv() {
        return String.format(Locale.US, "%s,%d,%d,%d", distanceKm, hours, minutes, seconds);
    }
}
