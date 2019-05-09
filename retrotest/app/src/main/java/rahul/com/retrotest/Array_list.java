package rahul.com.retrotest;

import com.google.gson.annotations.SerializedName;

class Array_list {
    @SerializedName("Drug_Id")
    public String Drug_Id;

    @SerializedName("Org_Id")
    public String Org_Id;

    @SerializedName("Unit_Id")
    public String Unit_Id;

    @SerializedName("Genric_name")
    public String Genric_name;

    @SerializedName("Created_By")
    public String Created_By;

    public String getDrug_Id() {
        return Drug_Id;
    }

    public void setDrug_Id(String drug_Id) {
        Drug_Id = drug_Id;
    }

    public String getOrg_Id() {
        return Org_Id;
    }

    public void setOrg_Id(String org_Id) {
        Org_Id = org_Id;
    }

    public String getUnit_Id() {
        return Unit_Id;
    }

    public void setUnit_Id(String unit_Id) {
        Unit_Id = unit_Id;
    }

    public String getGenric_name() {
        return Genric_name;
    }

    public void setGenric_name(String genric_name) {
        Genric_name = genric_name;
    }

    public String getCreated_By() {
        return Created_By;
    }

    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }
}
