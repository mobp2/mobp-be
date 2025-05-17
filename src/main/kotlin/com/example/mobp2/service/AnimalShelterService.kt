package com.example.mobp2.service

import com.example.mobp2.client.AnimalShelterClient
import com.example.mobp2.dto.AnimalInShelterResponse
import com.example.mobp2.dto.ShelterResponse
import org.springframework.stereotype.Service

@Service
class AnimalShelterService(
    private val animalShelterClient: AnimalShelterClient
) {
    fun getShelterData(): List<ShelterResponse> {
        val shelterResponses = animalShelterClient.getAnimlalShelters()
        println(shelterResponses[0])
        return shelterResponses
    }

    fun getAnimalInShelterData(careRegNo: String): List<AnimalInShelterResponse> {
        val animalInShelterResponses = animalShelterClient.getAnimalsInShelter(careRegNo)
        println(animalInShelterResponses)
        return animalInShelterResponses
    }
}
