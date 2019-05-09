package rahul.com.retrotest;

import com.google.gson.annotations.SerializedName;

class CreatedDate {
    @SerializedName("date")
    private String date;

    @SerializedName("timezone_type")
    private Integer timezone_type;

    @SerializedName("timezone")
    private String timezone;

    public CreatedDate(String date, Integer timezone_type, String timezone) {
        this.date = date;
        this.timezone_type = timezone_type;
        this.timezone = timezone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTimezone_type() {
        return timezone_type;
    }

    public void setTimezone_type(Integer timezone_type) {
        this.timezone_type = timezone_type;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
