package vn.edu.eiu.cse456.fecse4562131200119review.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.edu.eiu.cse456.fecse4562131200119review.model.Equipment;
import vn.edu.eiu.cse456.fecse4562131200119review.model.EquipmentType;
import vn.edu.eiu.cse456.fecse4562131200119review.model.User;
import vn.edu.eiu.cse456.fecse4562131200119review.service.EquipmentService;
import vn.edu.eiu.cse456.fecse4562131200119review.service.EquipmentTypeService;
import vn.edu.eiu.cse456.fecse4562131200119review.service.UserService;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    EquipmentTypeService equipmentTypeService;
    @Autowired
    EquipmentService equipmentService;
    @Override
    public void run(String... args) throws Exception {
        User admin = new User("Admin", "admin", 1);
        User staff = new User("Staff", "staff", 2);
        User customer1 = new User("Nhi Truong", "nhitruong", 3);
        userService.save(admin);
        userService.save(staff);
        userService.save(customer1);

        EquipmentType type1 = new EquipmentType("Laptop", "Portable computers used for teaching/research");
        EquipmentType type2 = new EquipmentType("Projector", "Devices used for classroom presentations");
        EquipmentType type3 = new EquipmentType("Printer", "Printers for administrative/student use");
        EquipmentType type4 = new EquipmentType("Microscope", "Lab equipment for biology/medical courses");

        Equipment equipment1 = new Equipment("EQ00000001", "Dell Latitude 5420", 1500.00, 20);
        Equipment equipment2 = new Equipment("EQ00000002", "HP ProBook 450 G8", 1350.00, 15);
        Equipment equipment3 = new Equipment("EQ00000003", "Epson EB-X06 Projector", 2200.00, 5);
        Equipment equipment4 = new Equipment("EQ00000004", "BenQ MW550 Projector", 2500.00, 3);
        Equipment equipment5 = new Equipment("EQ00000005", "Canon LBP2900 Printer", 1200.00, 10);
        Equipment equipment6 = new Equipment("EQ00000006", "Olympus CX23 Microscope", 5000.00, 7);

        type1.addEquipment(equipment1);
        type1.addEquipment(equipment2);
        type2.addEquipment(equipment3);
        type2.addEquipment(equipment4);
        type3.addEquipment(equipment5);
        type4.addEquipment(equipment6);

        equipmentTypeService.save(type1);
        equipmentTypeService.save(type2);
        equipmentTypeService.save(type3);
        equipmentTypeService.save(type4);


    }
}
