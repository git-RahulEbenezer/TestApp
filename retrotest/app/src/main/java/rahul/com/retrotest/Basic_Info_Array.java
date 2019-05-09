package rahul.com.retrotest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Basic_Info_Array {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("unit_id")
    @Expose
    private String unitId;
    @SerializedName("org_id")
    @Expose
    private String orgId;
    @SerializedName("Basic_Info_Id")
    @Expose
    private String basicInfoId;
    @SerializedName("Patientid")
    @Expose
    private String patientid;
    @SerializedName("Height")
    @Expose
    private Integer height;
    @SerializedName("Weight")
    @Expose
    private Integer weight;
    @SerializedName("Waist")
    @Expose
    private Integer waist;
    @SerializedName("Hip")
    @Expose
    private Integer hip;
    @SerializedName("Systolic_Bp")
    @Expose
    private Integer systolicBp;
    @SerializedName("Diastolic_Bp")
    @Expose
    private Integer diastolicBp;
    @SerializedName("Physical_Activity")
    @Expose
    private Integer physicalActivity;
    @SerializedName("Tobbaco")
    @Expose
    private Integer tobbaco;
    @SerializedName("Alcohol")
    @Expose
    private Integer alcohol;
    @SerializedName("Pulse_Pressure")
    @Expose
    private Integer pulsePressure;
    @SerializedName("Temprature")
    @Expose
    private Integer temprature;
    @SerializedName("Pulse")
    @Expose
    private Integer pulse;
    @SerializedName("Head_Circumference")
    @Expose
    private Integer headCircumference;
    @SerializedName("R_R")
    @Expose
    private Integer rR;
    @SerializedName("Is_Hypertensive")
    @Expose
    private Integer isHypertensive;
    @SerializedName("Is_Diabetic")
    @Expose
    private Integer isDiabetic;
    @SerializedName("HIV_Tested_One_Year")
    @Expose
    private Integer hIVTestedOneYear;
    @SerializedName("On_Treatment_HIV")
    @Expose
    private Integer onTreatmentHIV;
    @SerializedName("Created_By")
    @Expose
    private String createdBy;
    @SerializedName("Created_Date")
    @Expose
    private CreatedDate createdDate;
    @SerializedName("Edited_By")
    @Expose
    private Object editedBy;
    @SerializedName("Edited_Date")
    @Expose
    private Object editedDate;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("Smoke_Score")
    @Expose
    private Integer smokeScore;
    @SerializedName("Alcohol_Score")
    @Expose
    private Integer alcoholScore;
    @SerializedName("Target_organ_damage")
    @Expose
    private Integer targetOrganDamage;
    @SerializedName("Hist_Cardiovascular_Disease")
    @Expose
    private Integer histCardiovascularDisease;
    @SerializedName("thyroxine_replacement_therapy")
    @Expose
    private Integer thyroxineReplacementTherapy;
    @SerializedName("treat_Thyrotoxicosis")
    @Expose
    private Integer treatThyrotoxicosis;
    @SerializedName("Stat_therapy")
    @Expose
    private Integer statTherapy;
    @SerializedName("MUAC")
    @Expose
    private Integer mUAC;
    @SerializedName("oxygenconcentration")
    @Expose
    private Integer oxygenconcentration;

    public Basic_Info_Array(String id, String unitId, String orgId, String basicInfoId, String patientid, Integer height, Integer weight, Integer waist, Integer hip, Integer systolicBp, Integer diastolicBp, Integer physicalActivity, Integer tobbaco, Integer alcohol, Integer pulsePressure, Integer temprature, Integer pulse, Integer headCircumference, Integer rR, Integer isHypertensive, Integer isDiabetic, Integer hIVTestedOneYear, Integer onTreatmentHIV, String createdBy, CreatedDate createdDate, Object editedBy, Object editedDate, Integer status, Integer smokeScore, Integer alcoholScore, Integer targetOrganDamage, Integer histCardiovascularDisease, Integer thyroxineReplacementTherapy, Integer treatThyrotoxicosis, Integer statTherapy, Integer mUAC, Integer oxygenconcentration) {
        this.id = id;
        this.unitId = unitId;
        this.orgId = orgId;
        this.basicInfoId = basicInfoId;
        this.patientid = patientid;
        this.height = height;
        this.weight = weight;
        this.waist = waist;
        this.hip = hip;
        this.systolicBp = systolicBp;
        this.diastolicBp = diastolicBp;
        this.physicalActivity = physicalActivity;
        this.tobbaco = tobbaco;
        this.alcohol = alcohol;
        this.pulsePressure = pulsePressure;
        this.temprature = temprature;
        this.pulse = pulse;
        this.headCircumference = headCircumference;
        this.rR = rR;
        this.isHypertensive = isHypertensive;
        this.isDiabetic = isDiabetic;
        this.hIVTestedOneYear = hIVTestedOneYear;
        this.onTreatmentHIV = onTreatmentHIV;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.editedBy = editedBy;
        this.editedDate = editedDate;
        this.status = status;
        this.smokeScore = smokeScore;
        this.alcoholScore = alcoholScore;
        this.targetOrganDamage = targetOrganDamage;
        this.histCardiovascularDisease = histCardiovascularDisease;
        this.thyroxineReplacementTherapy = thyroxineReplacementTherapy;
        this.treatThyrotoxicosis = treatThyrotoxicosis;
        this.statTherapy = statTherapy;
        this.mUAC = mUAC;
        this.oxygenconcentration = oxygenconcentration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getBasicInfoId() {
        return basicInfoId;
    }

    public void setBasicInfoId(String basicInfoId) {
        this.basicInfoId = basicInfoId;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWaist() {
        return waist;
    }

    public void setWaist(Integer waist) {
        this.waist = waist;
    }

    public Integer getHip() {
        return hip;
    }

    public void setHip(Integer hip) {
        this.hip = hip;
    }

    public Integer getSystolicBp() {
        return systolicBp;
    }

    public void setSystolicBp(Integer systolicBp) {
        this.systolicBp = systolicBp;
    }

    public Integer getDiastolicBp() {
        return diastolicBp;
    }

    public void setDiastolicBp(Integer diastolicBp) {
        this.diastolicBp = diastolicBp;
    }

    public Integer getPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(Integer physicalActivity) {
        this.physicalActivity = physicalActivity;
    }

    public Integer getTobbaco() {
        return tobbaco;
    }

    public void setTobbaco(Integer tobbaco) {
        this.tobbaco = tobbaco;
    }

    public Integer getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Integer alcohol) {
        this.alcohol = alcohol;
    }

    public Integer getPulsePressure() {
        return pulsePressure;
    }

    public void setPulsePressure(Integer pulsePressure) {
        this.pulsePressure = pulsePressure;
    }

    public Integer getTemprature() {
        return temprature;
    }

    public void setTemprature(Integer temprature) {
        this.temprature = temprature;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Integer getHeadCircumference() {
        return headCircumference;
    }

    public void setHeadCircumference(Integer headCircumference) {
        this.headCircumference = headCircumference;
    }

    public Integer getrR() {
        return rR;
    }

    public void setrR(Integer rR) {
        this.rR = rR;
    }

    public Integer getIsHypertensive() {
        return isHypertensive;
    }

    public void setIsHypertensive(Integer isHypertensive) {
        this.isHypertensive = isHypertensive;
    }

    public Integer getIsDiabetic() {
        return isDiabetic;
    }

    public void setIsDiabetic(Integer isDiabetic) {
        this.isDiabetic = isDiabetic;
    }

    public Integer gethIVTestedOneYear() {
        return hIVTestedOneYear;
    }

    public void sethIVTestedOneYear(Integer hIVTestedOneYear) {
        this.hIVTestedOneYear = hIVTestedOneYear;
    }

    public Integer getOnTreatmentHIV() {
        return onTreatmentHIV;
    }

    public void setOnTreatmentHIV(Integer onTreatmentHIV) {
        this.onTreatmentHIV = onTreatmentHIV;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public CreatedDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(CreatedDate createdDate) {
        this.createdDate = createdDate;
    }

    public Object getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(Object editedBy) {
        this.editedBy = editedBy;
    }

    public Object getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(Object editedDate) {
        this.editedDate = editedDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSmokeScore() {
        return smokeScore;
    }

    public void setSmokeScore(Integer smokeScore) {
        this.smokeScore = smokeScore;
    }

    public Integer getAlcoholScore() {
        return alcoholScore;
    }

    public void setAlcoholScore(Integer alcoholScore) {
        this.alcoholScore = alcoholScore;
    }

    public Integer getTargetOrganDamage() {
        return targetOrganDamage;
    }

    public void setTargetOrganDamage(Integer targetOrganDamage) {
        this.targetOrganDamage = targetOrganDamage;
    }

    public Integer getHistCardiovascularDisease() {
        return histCardiovascularDisease;
    }

    public void setHistCardiovascularDisease(Integer histCardiovascularDisease) {
        this.histCardiovascularDisease = histCardiovascularDisease;
    }

    public Integer getThyroxineReplacementTherapy() {
        return thyroxineReplacementTherapy;
    }

    public void setThyroxineReplacementTherapy(Integer thyroxineReplacementTherapy) {
        this.thyroxineReplacementTherapy = thyroxineReplacementTherapy;
    }

    public Integer getTreatThyrotoxicosis() {
        return treatThyrotoxicosis;
    }

    public void setTreatThyrotoxicosis(Integer treatThyrotoxicosis) {
        this.treatThyrotoxicosis = treatThyrotoxicosis;
    }

    public Integer getStatTherapy() {
        return statTherapy;
    }

    public void setStatTherapy(Integer statTherapy) {
        this.statTherapy = statTherapy;
    }

    public Integer getmUAC() {
        return mUAC;
    }

    public void setmUAC(Integer mUAC) {
        this.mUAC = mUAC;
    }

    public Integer getOxygenconcentration() {
        return oxygenconcentration;
    }

    public void setOxygenconcentration(Integer oxygenconcentration) {
        this.oxygenconcentration = oxygenconcentration;
    }
}
