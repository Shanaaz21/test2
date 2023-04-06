package com.example.UniversitySuggestion.controller;


import com.example.UniversitySuggestion.model.PredictModel;
import com.example.UniversitySuggestion.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class indexController {

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }
    @PostMapping("/predict")
    public String studentDetails(@ModelAttribute Student student, Model model) throws JsonProcessingException {
        System.out.println(student.toString());
        String url = "http://localhost:5000/predict";

        PredictModel predictModel = new PredictModel();
        predictModel.setQualityOfEducation(student.getQualityOfEducation());
        predictModel.setQualityOfFaculty(student.getQualityOfEducation());
        predictModel.setInfluence(student.getInfluence());
        predictModel.setScore(student.getScore());

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PredictModel> request = new HttpEntity<>(predictModel, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println(response.getBody());
        if(response.getStatusCode() == HttpStatus.OK){
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String,String> responseMap = objectMapper.readValue(response.getBody(), new TypeReference<Map<String, String>>(){});
            student.setInstitution(responseMap.get("institution"));
            student.setQualityOfEducation(Double.parseDouble(responseMap.get("quality_of_education")));
            student.setQualityOfFaculty(Double.parseDouble(responseMap.get("quality_of_faculty")));
            student.setInfluence(Double.parseDouble(responseMap.get("influence")));
            student.setScore(Double.parseDouble(responseMap.get("score")));
            model.addAttribute(student);
            System.out.println(student);
            return "details";
        }
        return "error";
    }
}
