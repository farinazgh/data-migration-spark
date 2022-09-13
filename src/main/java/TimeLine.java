import java.util.Arrays;
import java.util.Objects;

public class TimeLine {
    public double duration;
    public double start;
    public String type;
    public String id;
    public Body[] body;
    public String image;
    public String description;

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Body[] getBody() {
        return body;
    }

    public void setBody(Body[] body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeLine)) return false;
        TimeLine timeLine = (TimeLine) o;
        return Double.compare(timeLine.getDuration(), getDuration()) == 0 && Double.compare(timeLine.getStart(), getStart()) == 0 && Objects.equals(getType(), timeLine.getType()) && Objects.equals(getId(), timeLine.getId()) && Arrays.equals(getBody(), timeLine.getBody()) && Objects.equals(getImage(), timeLine.getImage()) && Objects.equals(getDescription(), timeLine.getDescription());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getDuration(), getStart(), getType(), getId(), getImage(), getDescription());
        result = 31 * result + Arrays.hashCode(getBody());
        return result;
    }
}
