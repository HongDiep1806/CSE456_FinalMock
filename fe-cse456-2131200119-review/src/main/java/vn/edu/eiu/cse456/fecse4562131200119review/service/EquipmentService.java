package vn.edu.eiu.cse456.fecse4562131200119review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.cse456.fecse4562131200119review.model.Equipment;
import vn.edu.eiu.cse456.fecse4562131200119review.repository.EquipmentRepo;

import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    EquipmentRepo equipmentRepo;
    public void save (Equipment equipment) {
        equipmentRepo.save(equipment);
    }
    public List<Equipment> findAll() {
        return equipmentRepo.findAll();
    }
    public Equipment findById(String id) {
        return equipmentRepo.findByEquipmentId(id);
    }
    public void delete (Equipment equipment) {
        equipmentRepo.delete(equipment);
    }
    public boolean checkExists(String id) {
        return equipmentRepo.existsById(id);
    }
}
