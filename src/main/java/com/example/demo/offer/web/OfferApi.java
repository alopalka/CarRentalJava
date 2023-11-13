package com.example.demo.offer.web;

import com.example.demo.offer.domain.command.CreateOfferCommand;
import com.example.demo.offer.domain.command.UpdateOfferCommand;
import com.example.demo.offer.domain.dto.OfferDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/offers")
@Tag(name = "Offer Management",
        description = "APIs that handle operations related to managing offers including creating, reading, updating, " +
                "and deleting offers details.")

public interface OfferApi {

    @GetMapping
    @Operation(summary = "Retrieve a paginated list of offers",
            description = "Provides a list of offers with pagination")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved paginated list of offers")
    Page<OfferDto> findAll(Pageable pageable);

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve a offer by ID",
            description = "Fetch a specific offer using its ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved offer details")
    @ApiResponse(responseCode = "404", description = "Error when offer with id is not found")
    OfferDto findById(
            @Parameter(description = "Unique ID of the offer")
            @PathVariable(name = "id") Long offerId
    );

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new offer",
            description = "Add a new offer and return its details")
    @ApiResponse(responseCode = "201", description = "Successfully created a new offer")
    @ApiResponse(responseCode = "400", description = "Failed to create offer with error details")
    OfferDto saveOffer(
            @Parameter(description = "Offer details to create") CreateOfferCommand command
    );

    @PutMapping
    @Operation(summary = "Update an existing offer",
            description = "Modify an existing offer details using its ID")
    @ApiResponse(responseCode = "200", description = "Successfully updated the offer details")
    @ApiResponse(responseCode = "404", description = "Error when offer with id is not found")
    @ApiResponse(responseCode = "400", description = "Failed to update offer with error details")
    OfferDto updateOffer(
            @Parameter(description = "Updated offer details") UpdateOfferCommand command
    );

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a offer by its ID",
            description = "Remove a offer using its ID")
    @ApiResponse(responseCode = "204", description = "Successfully deleted the offer")
    void deleteOffer(
            @Parameter(description = "Unique ID of the offer")
            @PathVariable(name = "id") Long offerId
    );
}
