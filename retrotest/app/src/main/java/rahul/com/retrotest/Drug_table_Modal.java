package rahul.com.retrotest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/*
 * Created by Tony stark
 * */
public class Drug_table_Modal {
    @SerializedName("response")
    private String response;

    @SerializedName("data")
    List<Drug_table_Modal_Array> data;

    @SerializedName("message")
    private String message;

    public Drug_table_Modal(String response, List<Drug_table_Modal_Array> data) {
        this.response = response;
        this.data = data;
    }

    public List<Drug_table_Modal_Array> getData() {
        return data;
    }

    public void setData(List<Drug_table_Modal_Array> data) {
        this.data = data;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
