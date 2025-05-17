package com.example.mobp2.client

import com.example.mobp2.dto.AnimalApiResponse
import com.example.mobp2.dto.AnimalInShelterResponse
import com.example.mobp2.dto.ShelterResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.util.UriComponentsBuilder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Component
class AnimalShelterClient(
    private val builder: RestClient.Builder
) {
    private val restClient = builder.build()

    @Value("\${animal.secret_key}")
    private lateinit var serviceKey: String

    fun getAnimlalShelters(): List<ShelterResponse> {
        val encodedServiceKey = URLEncoder.encode(serviceKey, StandardCharsets.UTF_8)

        val shelterResponse = restClient.get()
            .uri(
                UriComponentsBuilder.newInstance().scheme("https")
                    .host("apis.data.go.kr")
                    .path("/1543061/animalShelterSrvc_v2/shelterInfo_v2")
                    .queryParam("serviceKey", encodedServiceKey)
                    .queryParam("numOfRows", "1000")
                    .queryParam("_type", "json")
                    .build(true)
                    .toUri()
            )
            .retrieve()
            .body(object : ParameterizedTypeReference<AnimalApiResponse<ShelterResponse>>() {})

        return shelterResponse?.response?.body?.items?.item ?: emptyList()
    }

    fun getAnimalsInShelter(careRegNo: String): List<AnimalInShelterResponse> {
        val encodedServiceKey = URLEncoder.encode(serviceKey, StandardCharsets.UTF_8)

        val shelterResponse = restClient.get()
            .uri(
                UriComponentsBuilder.newInstance().scheme("https")
                    .host("apis.data.go.kr")
                    .path("/1543061/abandonmentPublicService_v2/abandonmentPublic_v2")
                    .queryParam("care_reg_no", careRegNo)
                    .queryParam("serviceKey", encodedServiceKey)
                    .queryParam("numOfRows", "1000")
                    .queryParam("_type", "json")
                    .build(true)
                    .toUri()
            )
            .retrieve()
            .body(object : ParameterizedTypeReference<AnimalApiResponse<AnimalInShelterResponse>>() {})

        return shelterResponse?.response?.body?.items?.item?.filter { it.processState == "보호중" } ?: emptyList()
    }
}
