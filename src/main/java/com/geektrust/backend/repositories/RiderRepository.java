package com.geektrust.backend.repositories;

import java.util.HashMap;
import java.util.Map;

import com.geektrust.backend.entities.Rider;

public class RiderRepository implements IRiderRepository {

    private final Map<String,Rider> riderMap;
    
    public RiderRepository () {
        this.riderMap = new HashMap<>();
    }
    @Override
    public Rider save(Rider rider) {
        riderMap.put(rider.getId(), rider);
        return rider;
    }

    public Rider getRider(String id) {
        return riderMap.get(id);
    }
    
}
