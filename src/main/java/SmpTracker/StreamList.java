
package SmpTracker;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StreamList {

    @SerializedName("_total")
    @Expose
    private Integer total;
    @SerializedName("streams")
    @Expose
    private List<Streamers> streams = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Streamers> getStreamers() {
        return streams;
    }

    public void setStreams(List<Streamers> streams) {
        this.streams = streams;
    }

}
