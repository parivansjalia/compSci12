public class Time {
    private int hours;
    private int mins;

    public Time(int h, int m) {
        if (h < 25 && h > -1) {
            hours = h;
            mins = m;
        } else {
            throw new IllegalArgumentException("Enter another time");
        }

    }

    private int toMins() {
        return (hours * 60 + mins);
    }

    public boolean lessThan(Time t) {
        if (hours - t.hours > 0) {
            return false;
        } else if (hours - t.hours < 0) {
            return true;
        } else {
            if (mins - t.mins > 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public int elapsedSince(Time t) {
        int thiss = toMins();
        int other = t.toMins();

        if (thiss - other == 0) {
            return (0);
        } else if (thiss - other > 0) {
            return (24 * 60 - thiss + other);
        } else {
            return (other - thiss);
        }
    }

    public String toString() {
        return (hours + ":" + mins);
    }
}