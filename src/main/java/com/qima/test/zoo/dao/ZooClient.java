package com.qima.test.zoo.dao;

import com.qima.test.zoo.bean.Status;
import com.qima.test.zoo.bean.Animal;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@ConfigurationProperties(prefix = "data")
public class ZooClient {

    private List<Animal> animals;

    public List<Animal> getAll() {
        return this.animals;
    }

    public List<Animal> getAll(Status status) {
        return this.animals.stream().filter(a -> status == a.getStatue()).collect(Collectors.toList());
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public ReportVO getReport() {
        List<Animal> animals = this.animals;
        int aliveCount = 0;
        int deadCount = 0;
        int smallAnimalCount = 0;
        int mediumAnimalCount = 0;
        int largeAnimalCount = 0;
        Double minHeight = Double.MAX_VALUE;
        Double minWeight = Double.MAX_VALUE;
        Long minBirthTime = Long.MAX_VALUE;
        String shortestOne = "";
        String lightestOne = "";
        String oldestOne = "";
        int china = 0;
        int mexico = 0;
        int otherSourceCountry = 0;
        int mouse = 0;
        int Ox = 0;
        int otherCategory = 0;

        ReportVO reportVO = new ReportVO();

        for(int i = 0;i < animals.size(); i ++){
            Animal animal = animals.get(i);
            Status  status = animal. status;
            Double weight = animal. weight;
            Double height = animal. height;
            Long birthTime = animal.birthTime;
            String sourceCountry = animal.sourceCountry;
            AnimalCategory category = animal.category;

            if("ALIVE" == status){
                aliveCount++;
            }else{
                deadCount++;
            }

            if (height < minHeight) {
                minHeight = height;
                shortestOne = animal.name;
            }

            if (weight < minWeight) {
                minWeight = weight;
                lightestOne = animal.name;
            }
            if(weight < 30){
                smallAnimalCount++;
            }else if(weight >= 150){
                largeAnimalCount++;
            }else{
                mediumAnimalCount++;
            }
            if (birthTime < minBirthTime) {
                minBirthTime = birthTime;
                oldestOne = animal.name;
            }

            if("China"== sourceCountry){
                china++;
            }else if("Mexico"==value){
                mexico++;
            }else{
                otherSourceCountry++;
            }

            if("Mouse"== category){
                mouse++;
            }else if("Ox"== category){
                Ox++;
            }else{
                otherCategory++;
            }
        }
        JSONObject overallJsonObject = new JSONObject();
        JSONObject sizeJsonObject = new JSONObject();
        JSONObject sourceCountryJsonObject = new JSONObject();
        JSONObject categoryJsonObject = new JSONObject();

        overallJsonObject.put("aliveCount", aliveCount);
        overallJsonObject.put("deadCount", deadCount);
        overallJsonObject.put("lightestOne", lightestOne);
        overallJsonObject.put("shortestOne", shortestOne);
        overallJsonObject.put("oldestOne", oldestOne);
        sizeJsonObject.put("Small animal count", smallAnimalCount);
        sizeJsonObject.put("Medium animal count", mediumAnimalCount);
        sizeJsonObject.put("Large animal count", largeAnimalCount);
        sourceCountryJsonObject.put("China", china);
        sourceCountryJsonObject.put("Mexico", mexico);
        sourceCountryJsonObject.put("OtherSourceCountry", otherSourceCountry);
        categoryJsonObject.put("Mouse", mouse);
        categoryJsonObject.put("Ox", Ox);
        categoryJsonObject.put("OtherCategory", otherCategory);

        ReportVO reportVO = new ReportVO();
        reportVO.setOverall(overallJsonObject);
        reportVO.setSizeJsonObject sizeJsonObject);
        reportVO.setSourceCountry(JSONObject sourceCountryJsonObject);
        reportVO.setCategory(JSONObject categoryJsonObject);

        return reportVO;
    }

    public String getShow(String category) {
        String show = "";
        if("DOG".equals(category)){
            show = "Bark bark";
        }else if("MONKEY".equals(category)){
            show = "讲个笑话！";
        }
        return show;
    }
}
