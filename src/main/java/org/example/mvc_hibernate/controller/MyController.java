package org.example.mvc_hibernate.controller;

import org.example.mvc_hibernate.entity.Employee;
import org.example.mvc_hibernate.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private BaseService<Employee> baseService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = baseService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);

        return "employees";
    }

    @RequestMapping("/add")
    public String addNewEmployee(Model model) {
        model.addAttribute("emp", new Employee());

        return "add";
    }

    @RequestMapping("/save")
    public String saveEmployee(@ModelAttribute("emp") Employee employee) {
        employee.setName(employee.getName().trim());
        employee.setSurname(employee.getSurname().trim());
        employee.setDepartment(employee.getDepartment().trim());

        if (employee.getName().isBlank()
                || employee.getSurname().isBlank()
                || employee.getDepartment().isBlank()
                || employee.getSalary() <= 0) {
            return "add";
        }


        baseService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/update")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        model.addAttribute("emp", baseService.getEmployee(id));
        return "add";
    }

    @RequestMapping("/delete")
    public String deleteEmployee(@RequestParam("empId") int id) {

        baseService.deleteEmployee(id);

        return "redirect:/";
    }
}
