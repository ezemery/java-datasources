package com.example.ezemery.controller;

import com.example.ezemery.entity.Plant;
import com.example.ezemery.entity.PlantDTO;
import com.example.ezemery.entity.Views;
import com.example.ezemery.service.PlantService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @GetMapping("dto")
    public PlantDTO getPlantDTO(String name){
        PlantDTO  plantDTO = new PlantDTO();
        Plant plant = plantService.getPlantByName(name);
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }

    @JsonView(Views.class)
    @GetMapping("jsonviewer")
    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }

    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long id) {
        return plantService.delivered(id);
    }

    @GetMapping("/under-price/{price}")
    @JsonView(Views.class)
    public List<Plant> plantsCheaperThan(@PathVariable BigDecimal price) {
        return plantService.findPlantsBelowPrice(price);
    }
}
