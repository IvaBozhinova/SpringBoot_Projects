package com.example.mobilele.service;

import com.example.mobilele.model.AddOfferDTO;
import com.example.mobilele.model.OfferDetailsDTO;
import com.example.mobilele.model.OfferSummaryDTO;

import java.util.List;

public interface OfferService {

    long createOrder(AddOfferDTO addOfferDTO);

    void deleteOffer(long orderId);

    OfferDetailsDTO getOfferDetails(Long id);

    List<OfferSummaryDTO> getAllOffersSummary();
}
