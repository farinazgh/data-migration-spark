import java.sql.Timestamp;
import java.util.List;

public class Episode {

    private String id;

    private String name;
    public String author;
    public String contentType;
    public String description;
    public String episodeType;
    public String image;
    public String imageTitle;
    public String link;
    public String rssLink;
    public String mediaUrl;
    public String rssGuid;
    public String showId;
    public String subtitle;
    public String summary;
    public String rating;
    public String url;
    public String sourceMediaUrl;
    public String sourceMediaFilename;
    public String partitionKey;
    public String type;
    public long contentLength;
    public double duration;
    public AdSettings adSettings;

    public List<TimeLine> timeline;

    public List<Body> body;

    public List<String> categories;

    public List<String> keywords;

    public List<String> tags;

    public List<String> permissions;

    public List<String> sourceMediaUrls;


    public Original original;

    public Timestamp lastPublished;

    public Timestamp publishingDate;
    public Timestamp created;
    public Timestamp modified;

    public Long episodeNumber;
    public Integer seasonNumber;
    public Boolean hosted;
    public Boolean deleted;

    public Episode() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRssLink() {
        return rssLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getSourceMediaFilename() {
        return sourceMediaFilename;
    }

    public void setSourceMediaFilename(String sourceMediaFilename) {
        this.sourceMediaFilename = sourceMediaFilename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPartitionKey() {
        return partitionKey;
    }

    public void setPartitionKey(String partitionKey) {
        this.partitionKey = partitionKey;
    }

    public Long getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Long episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
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

    public AdSettings getAdSettings() {
        return adSettings;
    }

    public void setAdSettings(AdSettings adSettings) {
        this.adSettings = adSettings;
    }

    public List<TimeLine> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<TimeLine> timeline) {
        this.timeline = timeline;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<String> getSourceMediaUrls() {
        return sourceMediaUrls;
    }

    public void setSourceMediaUrls(List<String> sourceMediaUrls) {
        this.sourceMediaUrls = sourceMediaUrls;
    }

    public void setOriginal(Original original) {
        this.original = original;
    }

    public Original getOriginal() {
        return original;
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

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public List<Body> getBody() {
        return body;
    }

    public void setBody(List<Body> body) {
        this.body = body;
    }


    @Override
    public String toString() {
        return "Episode{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", contentType='" + contentType + '\'' +
                ", description='" + description + '\'' +
                ", episodeType='" + episodeType + '\'' +
                ", image='" + image + '\'' +
                ", imageTitle='" + imageTitle + '\'' +
                ", link='" + link + '\'' +
                ", rssLink='" + rssLink + '\'' +
                ", mediaUrl='" + mediaUrl + '\'' +
                ", rssGuid='" + rssGuid + '\'' +
                ", showId='" + showId + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", summary='" + summary + '\'' +
                ", rating='" + rating + '\'' +
                ", url='" + url + '\'' +
                ", sourceMediaUrl='" + sourceMediaUrl + '\'' +
                ", sourceMediaFilename='" + sourceMediaFilename + '\'' +
                ", partitionKey='" + partitionKey + '\'' +
                ", type='" + type + '\'' +
                ", contentLength=" + contentLength +
                ", duration=" + duration +
                ", adSettings=" + adSettings +
                ", timeline=" + timeline +
                ", body=" + body +
                ", categories=" + categories +
                ", keywords=" + keywords +
                ", tags=" + tags +
                ", permissions=" + permissions +
                ", sourceMediaUrls=" + sourceMediaUrls +
                ", original=" + original +
                ", lastPublished=" + lastPublished +
                ", publishingDate=" + publishingDate +
                ", created=" + created +
                ", modified=" + modified +
                ", episodeNumber=" + episodeNumber +
                ", seasonNumber=" + seasonNumber +
                ", hosted=" + hosted +
                ", deleted=" + deleted +
                '}';
    }
}
