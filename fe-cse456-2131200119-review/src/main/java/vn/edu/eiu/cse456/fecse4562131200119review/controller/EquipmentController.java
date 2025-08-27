package vn.edu.eiu.cse456.fecse4562131200119review.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.cse456.fecse4562131200119review.model.Equipment;
import vn.edu.eiu.cse456.fecse4562131200119review.model.EquipmentType;
import vn.edu.eiu.cse456.fecse4562131200119review.model.User;
import vn.edu.eiu.cse456.fecse4562131200119review.service.EquipmentService;
import vn.edu.eiu.cse456.fecse4562131200119review.service.EquipmentTypeService;

import java.util.List;

@Controller
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;
    @Autowired
    EquipmentTypeService equipmentTypeService;

    @GetMapping("/equipments")
    public String equipments(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            redirectAttributes.addFlashAttribute("authorErr", "You are not authorized to access this function!");
            return "redirect:/login";
        }
        List<Equipment> equipments = equipmentService.findAll();
        model.addAttribute("equipments", equipments);
        return "equipment-list";
    }

    @GetMapping("/equipments/delete/{id}")
    public String deleteEquipment(@PathVariable String id, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            redirectAttributes.addFlashAttribute("authorErr", "You are not authorized to access this function!");
            return "redirect:/login";
        }
        if(user.getRole()==1) {
            Equipment equipment = equipmentService.findById(id);
            equipmentService.delete(equipment);
            return "redirect:/equipments";
        }else{
            redirectAttributes.addFlashAttribute("authorErr", "You are not allowed to access this function!");
            return "redirect:/equipments";
        }
    }
    @GetMapping("/equipments/new")
    public String newEquipment(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            redirectAttributes.addFlashAttribute("authorErr", "You are not authorized to access this function!");
            return "redirect:/login";
        }
        model.addAttribute("formMode", "create");
        model.addAttribute("equipment", new Equipment());
        List<EquipmentType> equipmentTypes = equipmentTypeService.findAll();
        model.addAttribute("equipmentTypes", equipmentTypes);

        return "equipment-form";
    }
    @GetMapping("/equipments/edit/{id}")
    public String editEquipment(@PathVariable String id,Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            redirectAttributes.addFlashAttribute("authorErr", "You are not authorized to access this function!");
            return "redirect:/login";
        }
        model.addAttribute("formMode", "edit");
        model.addAttribute("equipment", equipmentService.findById(id));
        List<EquipmentType> equipmentTypes = equipmentTypeService.findAll();
        model.addAttribute("equipmentTypes", equipmentTypes);

        return "equipment-form";
    }
    @PostMapping("/equipments/form")
    public String saveEquipment (@Valid @ModelAttribute Equipment equipment, BindingResult bindingResult, Model model, @RequestParam("formMode") String formMode, RedirectAttributes redirectAttributes,
                                 @RequestParam("equipmentTypeId") int equipmentTypeId) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            return "equipment-form";
        }
        if(formMode.equals("create")) {
            if (equipmentService.checkExists(equipment.getEquipmentId())){
                redirectAttributes.addFlashAttribute("duplicate", "This equipment already exists!");
                return "redirect:/equipments";
            }
        }

            EquipmentType et = equipmentTypeService.findById(equipmentTypeId);
            if(et!= null){
                System.out.println("cóoo");
            }
            equipment.setEquipmentType(et);

        equipmentService.save(equipment);
        return "redirect:/equipments";

    }

}
