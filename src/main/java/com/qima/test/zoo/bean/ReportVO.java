package com.qima.test.zoo.bean;

import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

@Data
@Builder
public class ReportVO implements Serializable{
    private JSONObject overallJsonObject;
    private JSONObject sizeJsonObject;
    private JSONObject sourceCountryJsonObject;
    private JSONObject categoryJsonObject;

    JSONObject reportVO = new JSONObject();
	reportVO.put("overall", overallJsonObject);
	reportVO.put("size", sizeJsonObject);
	reportVO.put("sourceCountry", sourceCountryJsonObject);
	reportVO.put("category", categoryJsonObject);

    public ReportVO() {
    }

    public Integer getOverall() {
        return overallJsonObject;
    }
    public void setOverall(JSONObject overallJsonObject) {
        this.overallJsonObject;
    }
    public Integer getSize() {
        return sizeJsonObject;
    }
    public void setSizeJsonObject sizeJsonObject) {
        this. sizeJsonObject;
    }
    public Integer getSourceCountry() {
        return sourceCountryJsonObject;
    }
    public void setSourceCountry(JSONObject sourceCountryJsonObject) {
        this.sourceCountryJsonObject;
    }
    public Integer getCategory() {
        return categoryJsonObject;
    }
    public void setCategory(JSONObject categoryJsonObject) {
        this.categoryJsonObject;
    }
}
