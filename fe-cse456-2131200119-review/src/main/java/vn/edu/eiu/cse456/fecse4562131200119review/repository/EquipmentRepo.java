package vn.edu.eiu.cse456.fecse4562131200119review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.cse456.fecse4562131200119review.model.Equipment;
@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, String> {
    public Equipment findByEquipmentId(String equipmentId);
}
