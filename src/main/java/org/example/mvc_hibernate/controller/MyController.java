package org.example.mvc_hibernate.controller;

import net.bytebuddy.matcher.StringMatcher;
import org.example.mvc_hibernate.dao.EmployeeDAO;
import org.example.mvc_hibernate.entity.Employee;
import org.example.mvc_hibernate.service.EmployeeService;
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
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = employeeService.getAllEmployees();
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


        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/update")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        model.addAttribute("emp", employeeService.getEmployee(id));
        return "add";
    }

    @RequestMapping("/delete")
    public String deleteEmployee(@RequestParam("empId") int id) {

        employeeService.deleteEmployee(id);

        return "redirect:/";
    }
}
