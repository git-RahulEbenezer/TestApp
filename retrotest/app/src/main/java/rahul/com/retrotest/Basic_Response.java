package rahul.com.retrotest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class Basic_Response {
    @SerializedName("response")
    private String response;

    @SerializedName("data")
    List<Basic_Info_Array> data;


    public Basic_Response(String response, List<Basic_Info_Array> data) {
        this.response = response;
        this.data = data;
    }

    public List<Basic_Info_Array> getData() {
        return data;
    }

    public void setData(List<Basic_Info_Array> data) {
        this.data = data;
    }

    public String getResponse() {

        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
