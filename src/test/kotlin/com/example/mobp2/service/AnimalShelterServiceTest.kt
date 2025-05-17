package com.example.mobp2.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AnimalShelterServiceTest {
    @Autowired
    private lateinit var animalShelterService: AnimalShelterService

    @Test
    fun name() {
        val shelterData = animalShelterService.getShelterData()
        animalShelterService.getAnimalInShelterData(shelterData[0].careRegNo ?: "341386200900001")
    }
}
