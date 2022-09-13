import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Original {
    public String id;
    public String author;
    public String[] categories;
    public String contentType;
    public String description;
    public String episodeType;
    public String image;
    public String imageTitle;
    public String[] keywords;
    public String link;
    public String rssLink;
    public String mediaUrl;
    public String name;
    public String rssGuid;
    public String showId;
    public String[] tags;
    public String[] permissions;
    public String subtitle;
    public String summary;
    public String rating;
    public String url;
    public String sourceMediaUrl;
    public String[] sourceMediaUrls;
    public String sourceMediaFilename;
    public long contentLength;
    public double duration;
    public Timestamp lastPublished;
    public Timestamp publishingDate;
    public Timestamp created;
    public Timestamp modified;
    public long episodeNumber;
    public int seasonNumber;
    public Boolean hosted;
    public Boolean deleted;
    public String partitionKey;
    public TimeLine[] timeline;
    AdSettings adSettings;

    public Original() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEpisodeType() {
        return episodeType;
    }

    public void setEpisodeType(String episodeType) {
        this.episodeType = episodeType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRssLink() {
        return rssLink;
    }

    public void setRssLink(String rssLink) {
        this.rssLink = rssLink;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRssGuid() {
        return rssGuid;
    }

    public void setRssGuid(String rssGuid) {
        this.rssGuid = rssGuid;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSourceMediaUrl() {
        return sourceMediaUrl;
    }

    public void setSourceMediaUrl(String sourceMediaUrl) {
        this.sourceMediaUrl = sourceMediaUrl;
    }

    public String[] getSourceMediaUrls() {
        return sourceMediaUrls;
    }

    public void setSourceMediaUrls(String[] sourceMediaUrls) {
        this.sourceMediaUrls = sourceMediaUrls;
    }

    public String getSourceMediaFilename() {
        return sourceMediaFilename;
    }

    public void setSourceMediaFilename(String sourceMediaFilename) {
        this.sourceMediaFilename = sourceMediaFilename;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Timestamp getLastPublished() {
        return lastPublished;
    }

    public void setLastPublished(Timestamp lastPublished) {
        this.lastPublished = lastPublished;
    }

    public Timestamp getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Timestamp publishingDate) {
        this.publishingDate = publishingDate;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public long getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(long episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Boolean getHosted() {
        return hosted;
    }

    public void setHosted(Boolean hosted) {
        this.hosted = hosted;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getPartitionKey() {
        return partitionKey;
    }

    public void setPartitionKey(String partitionKey) {
        this.partitionKey = partitionKey;
    }

    public TimeLine[] getTimeline() {
        return timeline;
    }

    public void setTimeline(TimeLine[] timeline) {
        this.timeline = timeline;
    }

    public AdSettings getAdSettings() {
        return adSettings;
    }

    public void setAdSettings(AdSettings adSettings) {
        this.adSettings = adSettings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Original)) return false;
        Original original = (Original) o;
        return getContentLength() == original.getContentLength() && Double.compare(original.getDuration(), getDuration()) == 0 && getEpisodeNumber() == original.getEpisodeNumber() && getSeasonNumber() == original.getSeasonNumber() && Objects.equals(getId(), original.getId()) && Objects.equals(getAuthor(), original.getAuthor()) && Arrays.equals(getCategories(), original.getCategories()) && Objects.equals(getContentType(), original.getContentType()) && Objects.equals(getDescription(), original.getDescription()) && Objects.equals(getEpisodeType(), original.getEpisodeType()) && Objects.equals(getImage(), original.getImage()) && Objects.equals(getImageTitle(), original.getImageTitle()) && Arrays.equals(getKeywords(), original.getKeywords()) && Objects.equals(getLink(), original.getLink()) && Objects.equals(getRssLink(), original.getRssLink()) && Objects.equals(getMediaUrl(), original.getMediaUrl()) && Objects.equals(getName(), original.getName()) && Objects.equals(getRssGuid(), original.getRssGuid()) && Objects.equals(getShowId(), original.getShowId()) && Arrays.equals(getTags(), original.getTags()) && Arrays.equals(getPermissions(), original.getPermissions()) && Objects.equals(getSubtitle(), original.getSubtitle()) && Objects.equals(getSummary(), original.getSummary()) && Objects.equals(getRating(), original.getRating()) && Objects.equals(getUrl(), original.getUrl()) && Objects.equals(getSourceMediaUrl(), original.getSourceMediaUrl()) && Arrays.equals(getSourceMediaUrls(), original.getSourceMediaUrls()) && Objects.equals(getSourceMediaFilename(), original.getSourceMediaFilename()) && Objects.equals(getLastPublished(), original.getLastPublished()) && Objects.equals(getPublishingDate(), original.getPublishingDate()) && Objects.equals(getCreated(), original.getCreated()) && Objects.equals(getModified(), original.getModified()) && Objects.equals(getHosted(), original.getHosted()) && Objects.equals(getDeleted(), original.getDeleted()) && Objects.equals(getPartitionKey(), original.getPartitionKey()) && Arrays.equals(getTimeline(), original.getTimeline()) && Objects.equals(getAdSettings(), original.getAdSettings());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getAuthor(), getContentType(), getDescription(), getEpisodeType(), getImage(), getImageTitle(), getLink(), getRssLink(), getMediaUrl(), getName(), getRssGuid(), getShowId(), getSubtitle(), getSummary(), getRating(), getUrl(), getSourceMediaUrl(), getSourceMediaFilename(), getContentLength(), getDuration(), getLastPublished(), getPublishingDate(), getCreated(), getModified(), getEpisodeNumber(), getSeasonNumber(), getHosted(), getDeleted(), getPartitionKey(), getAdSettings());
        result = 31 * result + Arrays.hashCode(getCategories());
        result = 31 * result + Arrays.hashCode(getKeywords());
        result = 31 * result + Arrays.hashCode(getTags());
        result = 31 * result + Arrays.hashCode(getPermissions());
        result = 31 * result + Arrays.hashCode(getSourceMediaUrls());
        result = 31 * result + Arrays.hashCode(getTimeline());
        return result;
    }
}
