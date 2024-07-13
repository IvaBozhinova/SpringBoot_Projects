package com.example.mobilele.model;

import com.example.mobilele.model.enums.EngineTypeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record AddOfferDTO(
        @NotEmpty(message = "{add.offer.description.not.empty}")
        @Size(message = "Description should be between 5 and 500 symbols.",
                min = 5,
                max = 500) String description,
        @NotNull @PositiveOrZero Integer mileage,
        @NotNull EngineTypeEnum engineType
) {

    public static AddOfferDTO empty() {
        return new AddOfferDTO(null, null, null);
    }

}