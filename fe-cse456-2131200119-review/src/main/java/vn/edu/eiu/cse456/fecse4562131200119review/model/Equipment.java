package vn.edu.eiu.cse456.fecse4562131200119review.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "tbl_Equipment")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Equipment {
    @Id
    @Column(name = "EquipmentId", columnDefinition = "CHAR(10)")
    private String equipmentId;
    @Column(name = "EquipmentName", columnDefinition = "VARCHAR(150)", nullable = false)
    @Size(min = 5, max = 100, message = "Equipment Name must be from 5 to 100 characters")
    private String equipmentName;
    @Column(name = "PurchasePrice", columnDefinition = "DECIMAL(10,2)", nullable = false)
    @Min(value = 1000, message = "Purchase price must be over 1000")
    private double purchasePrice;
    @Column(name = "QuantityAvailable", nullable = false)
    @Min(0)
    @Max(500)
    private int quantityAvailable;
    @CreatedDate
    private LocalDateTime purchaseDate;
    @ManyToOne
    @JoinColumn(name = "equipmentTypeId")
    private EquipmentType equipmentType; // dem qua one to many dat mapped

    public Equipment() {
    }

    public Equipment(String equipmentId, String equipmentName, double purchasePrice, int quantityAvailable) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.purchasePrice = purchasePrice;
        this.quantityAvailable = quantityAvailable;
        this.purchaseDate = LocalDateTime.now();
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public void setEquipmentName(@Size(min = 5, max = 100, message = "Equipment Name must be from 5 to 100 characters") String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public void setPurchasePrice(@Min(value = 1000, message = "Purchase price must be over 1000") double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setQuantityAvailable(@Min(0) @Max(500) int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public @Size(min = 5, max = 100, message = "Equipment Name must be from 5 to 100 characters") String getEquipmentName() {
        return equipmentName;
    }

    @Min(value = 1000, message = "Purchase price must be over 1000")
    public double getPurchasePrice() {
        return purchasePrice;
    }

    @Min(0)
    @Max(500)
    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }
}
