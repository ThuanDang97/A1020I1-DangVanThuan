package B12_Java_Collection_Framework.ThucHanh.Phan_Biet_HashMap_HashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class student {
    String name;
    int age;
    String address;

    public student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "HashMap_HashSet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        student student1 = new student("a", 20, "quang nam");
        student student2 = new student("c", 25, "da nang");
        student student3 = new student("a", 20, "hue");

        Map<Integer, student> stuMap = new HashMap<>();
        stuMap.put(1,student1);
        stuMap.put(2, student2);
        stuMap.put(3, student3);

        System.out.println("hashMap");
        for (Map.Entry<Integer, student> student : stuMap.entrySet()){
            System.out.println(student.toString());
        }

        Set<student> stuSet = new HashSet<>();
        stuSet.add(student1);
        stuSet.add(student2);
        stuSet.add(student3);
        System.out.println("hashSet");
        for (student str : stuSet){
            System.out.println(str);
        }
    }
}
