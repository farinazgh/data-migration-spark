import java.util.Objects;

public class AdSettings {

    public double adSettings;
    public double numberOfPrerollAds;
    public double numberOfPrerollSpons;
    public double numberOfMidrollAds;
    public double numberOfMidrollSpons;
    public double numberOfPostrollAds;
    public double numberOfPostrollSpons;

    public double getAdSettings() {
        return adSettings;
    }

    public void setAdSettings(double adSettings) {
        this.adSettings = adSettings;
    }

    public double getNumberOfPrerollAds() {
        return numberOfPrerollAds;
    }

    public void setNumberOfPrerollAds(double numberOfPrerollAds) {
        this.numberOfPrerollAds = numberOfPrerollAds;
    }

    public double getNumberOfPrerollSpons() {
        return numberOfPrerollSpons;
    }

    public void setNumberOfPrerollSpons(double numberOfPrerollSpons) {
        this.numberOfPrerollSpons = numberOfPrerollSpons;
    }

    public double getNumberOfMidrollAds() {
        return numberOfMidrollAds;
    }

    public void setNumberOfMidrollAds(double numberOfMidrollAds) {
        this.numberOfMidrollAds = numberOfMidrollAds;
    }

    public double getNumberOfMidrollSpons() {
        return numberOfMidrollSpons;
    }

    public void setNumberOfMidrollSpons(double numberOfMidrollSpons) {
        this.numberOfMidrollSpons = numberOfMidrollSpons;
    }

    public double getNumberOfPostrollAds() {
        return numberOfPostrollAds;
    }

    public void setNumberOfPostrollAds(double numberOfPostrollAds) {
        this.numberOfPostrollAds = numberOfPostrollAds;
    }

    public double getNumberOfPostrollSpons() {
        return numberOfPostrollSpons;
    }

    public void setNumberOfPostrollSpons(double numberOfPostrollSpons) {
        this.numberOfPostrollSpons = numberOfPostrollSpons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdSettings)) return false;
        AdSettings that = (AdSettings) o;
        return Double.compare(that.getAdSettings(), getAdSettings()) == 0 && Double.compare(that.getNumberOfPrerollAds(), getNumberOfPrerollAds()) == 0 && Double.compare(that.getNumberOfPrerollSpons(), getNumberOfPrerollSpons()) == 0 && Double.compare(that.getNumberOfMidrollAds(), getNumberOfMidrollAds()) == 0 && Double.compare(that.getNumberOfMidrollSpons(), getNumberOfMidrollSpons()) == 0 && Double.compare(that.getNumberOfPostrollAds(), getNumberOfPostrollAds()) == 0 && Double.compare(that.getNumberOfPostrollSpons(), getNumberOfPostrollSpons()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdSettings(), getNumberOfPrerollAds(), getNumberOfPrerollSpons(), getNumberOfMidrollAds(), getNumberOfMidrollSpons(), getNumberOfPostrollAds(), getNumberOfPostrollSpons());
    }
}
