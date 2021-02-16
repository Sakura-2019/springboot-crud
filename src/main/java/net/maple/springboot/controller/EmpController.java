package net.maple.springboot.controller;

import com.sun.xml.internal.ws.api.model.MEP;
import net.maple.springboot.dao.DepartmentDao;
import net.maple.springboot.dao.EmployeeDao;
import net.maple.springboot.entities.Department;
import net.maple.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    /**
     * 展示员工列表
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    /**
     * 跳转到添加页面
     */
    @GetMapping("/emp")
    public String toAdd(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    /**
     * 添加
     */
    @PostMapping("/emp")
    public String add(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    /**
     * 删除
     */
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
    /**
     * 跳转到修改页面
     */
    @GetMapping("/emp/{id}")
    public String toEdit(@PathVariable("id") Integer id,Model model){
        Employee employee=employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/update";
    }
    /**
     * 修改
     */
    @PutMapping("/emp")
    public String edit(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }


}
