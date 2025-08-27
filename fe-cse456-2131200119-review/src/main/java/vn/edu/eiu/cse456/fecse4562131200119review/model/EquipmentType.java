package vn.edu.eiu.cse456.fecse4562131200119review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_EquipmentType")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EquipmentTypeId")
    private Integer equipmentTypeId;
    @Column(name = "TypeName", columnDefinition = "VARCHAR(100)", nullable = false, unique = true)
    private String typeName;
    @Column(name = "Description", columnDefinition = "VARCHAR(255)", nullable = true)
    private String description;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "equipmentType")
    private List<Equipment> equipments = new ArrayList<>();

    public Integer getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getDescription() {
        return description;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public EquipmentType() {
    }

    public EquipmentType(String typeName, String description) {
        this.typeName = typeName;
        this.description = description;
    }
    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
        equipment.setEquipmentType(this);
    }
    public void removeEquipment(Equipment equipment) {
        this.equipments.remove(equipment);
        equipment.setEquipmentType(null);
    }
}
