
package com.example.tryspringdocker.repos;

import com.example.tryspringdocker.entity.TemperatureData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TemperatureDataRepository extends JpaRepository<TemperatureData, Long> {
    @Query("SELECT MAX(t.temperature) FROM TemperatureData t")
    Double findMaxTemperature();
    @Query("SELECT MIN(t.temperature) FROM TemperatureData t")
    Double findMinTemperature();
    @Query("SELECT AVG(t.temperature) FROM TemperatureData t")
    Double findAverageTemperature();
}
