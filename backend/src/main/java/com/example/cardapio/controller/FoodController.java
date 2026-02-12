package com.example.cardapio.controller;

import com.example.cardapio.controller.dto.CreateFoodDto;
import com.example.cardapio.controller.dto.FoodResponseDto;
import com.example.cardapio.entity.Food;
import com.example.cardapio.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void createFood(@RequestBody CreateFoodDto createFoodDto) {
        foodService.crateFood(createFoodDto);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDto> getAllFoods() {
        return foodService.getAllFoods();
    }

}
