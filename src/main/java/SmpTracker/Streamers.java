
package SmpTracker;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Streamers {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("game")
    @Expose
    private String game;
    @SerializedName("broadcast_platform")
    @Expose
    private String broadcastPlatform;
    @SerializedName("community_id")
    @Expose
    private String communityId;
    @SerializedName("community_ids")
    @Expose
    private List<String> communityIds = null;
    @SerializedName("viewers")
    @Expose
    private Integer viewers;
    @SerializedName("video_height")
    @Expose
    private Integer videoHeight;
    @SerializedName("average_fps")
    @Expose
    private Integer averageFps;
    @SerializedName("delay")
    @Expose
    private Integer delay;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("is_playlist")
    @Expose
    private Boolean isPlaylist;
    @SerializedName("stream_type")
    @Expose
    private String streamType;
    @SerializedName("preview")
    @Expose
    private Preview preview;
    @SerializedName("channel")
    @Expose
    private Channel channel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getBroadcastPlatform() {
        return broadcastPlatform;
    }

    public void setBroadcastPlatform(String broadcastPlatform) {
        this.broadcastPlatform = broadcastPlatform;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public List<String> getCommunityIds() {
        return communityIds;
    }

    public void setCommunityIds(List<String> communityIds) {
        this.communityIds = communityIds;
    }

    public Integer getViewers() {
        return viewers;
    }

    public void setViewers(Integer viewers) {
        this.viewers = viewers;
    }

    public Integer getVideoHeight() {
        return videoHeight;
    }

    public void setVideoHeight(Integer videoHeight) {
        this.videoHeight = videoHeight;
    }

    public Integer getAverageFps() {
        return averageFps;
    }

    public void setAverageFps(Integer averageFps) {
        this.averageFps = averageFps;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsPlaylist() {
        return isPlaylist;
    }

    public void setIsPlaylist(Boolean isPlaylist) {
        this.isPlaylist = isPlaylist;
    }

    public String getStreamType() {
        return streamType;
    }

    public void setStreamType(String streamType) {
        this.streamType = streamType;
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

}
