package rahul.com.retrotest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sign_In_Respose {
    @SerializedName("response")
    private String response;

    @SerializedName("data")
    List<Array_list> data;


    public Sign_In_Respose(String response, List<Array_list> data) {
        this.response = response;
        this.data = data;
    }

    public List<Array_list> getData() {
        return data;
    }

    public void setData(List<Array_list> data) {
        this.data = data;
    }

    public String getResponse() {

        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
