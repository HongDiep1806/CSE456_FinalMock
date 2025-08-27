package vn.edu.eiu.cse456.fecse4562131200119review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.cse456.fecse4562131200119review.model.EquipmentType;
import vn.edu.eiu.cse456.fecse4562131200119review.repository.EquipmentTypeRepo;

import java.util.List;

@Service
public class EquipmentTypeService {
    @Autowired
    EquipmentTypeRepo equipmentTypeRepo;
    public void save (EquipmentType equipmentType) {
        equipmentTypeRepo.save(equipmentType);
    }
    public List<EquipmentType> findAll() {
        return equipmentTypeRepo.findAll();
    }
    public EquipmentType findById(int id) {
        return equipmentTypeRepo.findByEquipmentTypeId(id);
    }
}
