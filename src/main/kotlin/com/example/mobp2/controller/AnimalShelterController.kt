package com.example.mobp2.controller

import com.example.mobp2.service.AnimalShelterService
import org.springframework.stereotype.Controller

@Controller
class AnimalShelterController(
    private val animalShelterService: AnimalShelterService,
) {
}
