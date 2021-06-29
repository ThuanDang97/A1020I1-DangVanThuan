package A1020I1_DangVanThuan_CaseStudy.Models;

import java.util.Stack;

public class FilingCabinets {
    private Stack<Employee> stack=new Stack<>();

    public FilingCabinets() {
    }
    public void add(Employee employee){
        stack.push(employee);
    }
    public Employee search(String name){
        for (Employee emp:stack) {
            if(emp.getNameEmp().equals(name))
                return emp;
        }
        return null;
    }
}
