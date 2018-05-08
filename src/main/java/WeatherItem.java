public class WeatherItem {
    // Class to store weather data of one day

    // Properties
    private final int day;
    private final int mxt;
    private final int mnt;

    // Constructor
    public WeatherItem(String day, String mxt, String mnt) {
        this.day = Integer.parseInt(day);
        this.mxt = Integer.parseInt(mxt);
        this.mnt = Integer.parseInt(mnt);
    }

    public int getDay() {
        return day;
    }

    public int getMxt() {
        return mxt;
    }

    public int getMnt() {
        return mnt;
    }
}
