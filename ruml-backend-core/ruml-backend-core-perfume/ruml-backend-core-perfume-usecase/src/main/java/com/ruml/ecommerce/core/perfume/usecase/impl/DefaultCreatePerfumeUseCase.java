package com.ruml.ecommerce.core.perfume.usecase.impl;

import com.ruml.ecommerce.core.perfume.entity.PerfumeEntity;
import com.ruml.ecommerce.core.perfume.entity.value.BottleVolume;
import com.ruml.ecommerce.core.perfume.entity.value.Concentration;
import com.ruml.ecommerce.core.perfume.entity.value.ScentProfile;
import com.ruml.ecommerce.core.perfume.factory.request.CreatePerfumeRequest;
import com.ruml.ecommerce.core.perfume.factory.response.CreatePerfumeResponse;
import com.ruml.ecommerce.core.perfume.identity.PerfumeId;
import com.ruml.ecommerce.core.perfume.port.PerfumePort;
import com.ruml.ecommerce.core.perfume.usecase.CreatePerfumeUseCase;
import java.util.UUID;

public class DefaultCreatePerfumeUseCase implements CreatePerfumeUseCase {

    private final PerfumePort perfumePort;

    public DefaultCreatePerfumeUseCase(PerfumePort perfumePort) {
        this.perfumePort = perfumePort;
    }

    @Override
    public CreatePerfumeResponse execute(CreatePerfumeRequest request) {
        PerfumeId newId = new PerfumeId(UUID.randomUUID().toString());
        
        ScentProfile scentProfile = new ScentProfile(
            request.topNotes(), 
            request.heartNotes(), 
            request.baseNotes()
        );
        
        BottleVolume volume = new BottleVolume(request.volumeMilliliters());
        Concentration concentration = Concentration.valueOf(request.concentration().toUpperCase());

        PerfumeEntity newPerfume = new PerfumeEntity(
            newId,
            request.name(),
            request.price(),
            scentProfile,
            volume,
            concentration,
            request.initialStock()
        );

        PerfumeEntity saved = perfumePort.save(newPerfume);
        return new CreatePerfumeResponse(saved.getId().value());
    }
}
