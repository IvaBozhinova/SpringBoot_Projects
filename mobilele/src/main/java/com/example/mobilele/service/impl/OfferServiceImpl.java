package com.example.mobilele.service.impl;

import com.example.mobilele.model.AddOfferDTO;
import com.example.mobilele.model.OfferDetailsDTO;
import com.example.mobilele.model.OfferSummaryDTO;
import com.example.mobilele.model.entity.OfferEntity;
import com.example.mobilele.repository.OfferRepository;
import com.example.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public long createOrder(AddOfferDTO addOfferDTO) {
        return offerRepository.save(map(addOfferDTO)).getId();
    }
    @Override
    public void deleteOffer(long orderId) {
        offerRepository.deleteById(orderId);
    }
    @Override
    public OfferDetailsDTO getOfferDetails(Long id) {

        return this.offerRepository
                .findById(id)
                .map(OfferServiceImpl::toOfferDetails)
                .orElseThrow();
    }

    private static OfferDetailsDTO toOfferDetails(OfferEntity offerEntity) {
        // todo use mapping library
        return new OfferDetailsDTO(offerEntity.getId(),
                offerEntity.getDescription(),
                offerEntity.getMileage(),
                offerEntity.getEngine());
    }

    private static OfferEntity map(AddOfferDTO addOfferDTO) {

        return new OfferEntity()
                .setDescription(addOfferDTO.description())
                .setEngine(addOfferDTO.engineType())
                .setMileage(addOfferDTO.mileage());
    }
    @Override
    public List<OfferSummaryDTO> getAllOffersSummary() {
        return offerRepository
                .findAll()
                .stream()
                .map(OfferServiceImpl::toOfferSummary)
                .toList();
    }
    private static OfferSummaryDTO toOfferSummary(OfferEntity offerEntity) {
        // todo use mapping library
        return new OfferSummaryDTO(offerEntity.getId(),
                offerEntity.getDescription(),
                offerEntity.getMileage(),
                offerEntity.getEngine());
    }
}
