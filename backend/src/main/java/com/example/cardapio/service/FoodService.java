package com.example.cardapio.service;

import com.example.cardapio.controller.dto.CreateFoodDto;
import com.example.cardapio.controller.dto.FoodResponseDto;
import com.example.cardapio.entity.Food;
import com.example.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<FoodResponseDto> getAllFoods() {
        var foods = foodRepository.findAll();

        return foods.stream()
                .map(food -> new FoodResponseDto(
                        food.getId(),
                        food.getTitle(),
                        food.getImage(),
                        food.getPrice()
                )).toList();
    }

    public void crateFood(CreateFoodDto createFoodDto) {
        var food = new Food(null, createFoodDto.title(), createFoodDto.image(), createFoodDto.price());

        foodRepository.save(food);
    }

}
