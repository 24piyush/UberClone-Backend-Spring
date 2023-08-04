package com.geektrust.backend.repositories;

import com.geektrust.backend.entities.Rider;

public interface IRiderRepository {
    public Rider save(Rider rider);
    public Rider getRider(String id);
}
