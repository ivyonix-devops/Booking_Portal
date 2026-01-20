package com.example.Transverra.TripTypeModelPackage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.poi.hpsf.Decimal;

import java.math.BigDecimal;

@Entity
@Table(name = "master_trip")
public class MasterTripModel {
    @Id
    @Column(name="master_id")
    private Long masterTripId;

    @Column(name = "trip_code")
    private String tripCode;   // OWT, RT, AA, etc.

    @Column(name = "trip_name")
    private String tripName;

    @Column(name = "fixed_rate", precision = 10, scale = 2, nullable = false)
    private BigDecimal  fixedRate;

    public Long getMasterTripId() {
        return masterTripId;
    }

    public void setMasterTripId(Long masterTripId) {
        this.masterTripId = masterTripId;
    }

    public String getTripCode() {
        return tripCode;
    }

    public void setTripCode(String tripCode) {
        this.tripCode = tripCode;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public BigDecimal  getFixedRate() {
        return fixedRate;
    }

    public void setFixedRate(BigDecimal fixedRate) {
        this.fixedRate = fixedRate;
    }
}
