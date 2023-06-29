package com.main.learn.stream;

import com.main.learn.model.Employee;
import com.main.learn.model.Student;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtils {

	public static void main(String[] args){
		
//		String[] strArray= {"b", "u", "s", "h", "r", "a"};
//
//		Stream<String> stream= Arrays.stream(strArray);
//		stream.forEach(x -> {System.out.print(x);});   //stream.forEach(System.out::print);
//		System.out.println();
//
//		Integer[] intArray= {0,1,2,3,4,4};
//		Stream<Integer> stream1= Stream.of(intArray);
//		stream1.forEach(x -> {System.out.print(x);});
//		System.out.println();
//
//		List<String> list= new ArrayList<>();
//		list.add("Java");
//		list.add(".Net");
//		list.add("Oracle");
//		list.add("Angular");
//		list.add("Phython");
//		list.stream().forEach(x -> {System.out.println(x);});
//
//		Stream<String> stream2 = Stream.generate(() -> "Hello Stream").limit(8);
//		String[] strArr = stream2.toArray(String[]::new);
//		System.out.println(Arrays.toString(strArr));

		List<Employee> employeeList= new ArrayList<Employee>();
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Ishaan Kayl", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Aman Gupta", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 35700.50));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.00));

		//finding count for male & female employees
		Map<String, Long> groupByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("Grouping by Gender with Male: " +groupByGender.get("Male") +" and Female: "+groupByGender.get("Female") +"\n");

		//List down department with employee details
		Map<String, List<Employee>> deptToEmpDetails= employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
		deptToEmpDetails.forEach((k,v)-> {
			System.out.println("Department Name: "+k +" Employee Details: "+v);
		});

		//List down department with Employee Names
		Map<String, List<String>> deptToEmpNames= employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
	//	System.out.println("\nMapping Department to employee names: "+deptToEmpNames);
		deptToEmpNames.forEach((k,v) -> {
			System.out.println("Department Name: "+k +" Employee Names: "+v);
		});

		//List down average salary as per gender
		Map<String, Double> avgSalByGender= employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("\nAverage Salary by Gender: "+avgSalByGender);

		//List down average age of employee
		Map<String, Double> avgAgeByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println("\nAverage Age as per gender: "+avgAgeByGender);

		//How many male and female employees are there in the sales and marketing team?
		Map<String, Long> deptFilterByGender = employeeList.stream().filter(x ->
				x.getDepartment().equals("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("\nThe count of employees in Sales and Marketing Male are: "+deptFilterByGender.get("Male") +" and Female are: "+deptFilterByGender.get("Female") +"\n");

		Map<Integer, String> hashMapTobeSorted= new HashMap<Integer, String>();
		hashMapTobeSorted.put(10,"Gill");
		hashMapTobeSorted.put(14,"Zay");
		hashMapTobeSorted.put(11,"Bob");
		hashMapTobeSorted.put(10,"Gax");
		hashMapTobeSorted.put(12,"Hem");
		hashMapTobeSorted.put(13,"Gav");
		hashMapTobeSorted.put(18,"Gax");
		//Way to sort key of hashmap using treemap-
		Map<Integer, String> sortedMap= new TreeMap<Integer, String>(hashMapTobeSorted);
		System.out.println("Sorted map is: "+sortedMap);
		//alternate way to sort keys of hashmap using stream
		hashMapTobeSorted.entrySet().stream().sorted(Map.Entry.<Integer,String>comparingByKey()).forEach(System.out::println);
		//way to sort values of hashmap using stream
		hashMapTobeSorted.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

		System.out.println("\nList of distinct department:");
		//List down all distinct departments
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

		System.out.println("\nPrinting names in ascending order order:");
		//Sorting List as per last name
		employeeList.stream().map(x -> x.getName()).sorted().forEach(System.out::println);

		System.out.println("\nPrinting names in descending order:");
		//Sorting List as per last name
		employeeList.stream().map(x->x.getName()).sorted(Comparator.reverseOrder()).forEach(System.out::println);

		employeeList.stream().map(x-> {
			Student student = new Student();
			student.setfName(x.getName());
			student.setlName(x.getDepartment());
			student.setMarks(90);
			return student;
		}).collect(Collectors.toList());


		//Highest paid employee in the org
		final Optional<Employee> maxSal= employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
		System.out.println("\nMaximum salary with Employee details: "+maxSal); //below is alternative
		Optional<Double> maximumSalary = employeeList.stream().map(Employee::getSalary).max(Comparator.comparingDouble(x -> x));
		System.out.println("\nMaximum salary of an Employee: "+maximumSalary);

		//Lowest paid employee in the org
		Optional<Employee> minSalary = employeeList.stream().min(Comparator.comparingDouble(Employee::getSalary));
		System.out.println("\nMinimum salary of an Employee: "+minSalary);

		List<Employee> sortedList = employeeList.stream().sorted(Comparator.comparingInt(Employee::getId)).collect((Collectors.toList()));
		System.out.println("\nMinimum salary of an Employee: "+sortedList);

		//Dept grp by gender
		Map<String, Map<String, Long>> deptGrpByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		System.out.println("\nDept group by Gender: "+deptGrpByGender);

		//Name of employee who's name starts with A
		employeeList.stream().filter(x->x.getName().startsWith("A")).forEach(System.out::println);
		//or
		List<String> nameStartsWith = employeeList.stream().filter(x -> x.getName().startsWith("A")).collect(Collectors.mapping(Employee::getName, Collectors.toList()));
		System.out.println("\nName Starts With A: "+nameStartsWith);

		//ID of employee who's ID starts with 1
		System.out.println("\nID Starts With 1: "); //convert id to string and then use startsWith method of String
		List<String> idStartsWithOne = employeeList.stream().map(x -> x.getId() + "").filter(s -> s.startsWith("1")).collect(Collectors.toList());
		System.out.println("Id starts with 1: "+idStartsWithOne);

		Map<Boolean, List<Employee>> empIdStartsWith = employeeList.stream().collect(Collectors.groupingBy(x -> String.valueOf(x.getId()).startsWith("1"), Collectors.toList()));
		System.out.println("Id starts with 1: "+empIdStartsWith.get(true));



		//empIdStartsWith

	}
}
