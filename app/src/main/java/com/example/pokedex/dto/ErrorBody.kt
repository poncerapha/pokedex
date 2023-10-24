package com.example.pokedex.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode

@JsonIgnoreProperties(ignoreUnknown = true)
data class ErrorBody(
    @JsonProperty("errorCode") val errorCode: String = UNKNOW_ERROR,
    @JsonProperty("message") val message: String = UNKNOW_ERROR
) {
    companion object {
        fun fromJson(jsonNode: JsonNode?) = ErrorBody(
            errorCode = jsonNode?.at("/errorCode")?.asText(UNKNOW_ERROR) ?: UNKNOW_ERROR,
            message = jsonNode?.at("/message")?.asText(UNKNOW_ERROR) ?: UNKNOW_ERROR
        )

        const val UNKNOW_ERROR = "UNKNOW_ERROR"
    }
}