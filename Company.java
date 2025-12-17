package streamApi;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Company {

	private String name;
	private double salary;

	public Company(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {

		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Company> companies = List.of(new Company("TCS", 98.45), new Company("Infosys", 78.55),
				new Company("Wipro", 65.20), new Company("HCL", 88.10), new Company("Tech Mahindra", 72.30));
		for (Company c : companies) {
			System.out.println(c.getName() + " and " + c.getSalary());
		}
		System.out.println("****************");
		// get salary of highest company
		Map<String, Double> rs = companies.stream().max(Comparator.comparingDouble(Company::getSalary))
				.map(c -> Map.of(c.getName(), c.getSalary())).orElse(Collections.emptyMap());
		System.out.println("Highest Salary: " + rs);

		// get 2nd highest salary
		Map<String, Double> mp = companies.stream().sorted(Comparator.comparingDouble(Company::getSalary).reversed())
				.skip(1).findFirst().map(c -> Map.of(c.getName(), c.getSalary())).orElse(Collections.emptyMap());
		System.out.println("2nd Highest Salary: " + mp);

		// get List<Company> whose salary > 75.00
		List<Company> ss = companies.stream().filter(n -> n.getSalary() > 75.00).toList();
		Map<String, Double> sp = companies.stream().filter(n -> n.getSalary() > 75.00)
				.collect(Collectors.toMap(Company::getName, Company::getSalary));
		System.out.println(" List<Company> whose salary > 75.00 " + ss);
		System.out.println("Map of Company whose sal > 75.00 " + sp);

		// sort and return salary in descending
		List<Company> sort = companies.stream().sorted(Comparator.comparingDouble(Company::getSalary).reversed())
				.toList();
		System.out.println("Sortted by salary: ");
		for (Company c : sort) {
			System.out.println(c.getName() + " & " + c.getSalary());
		}

//		Find second highest salary
//		👉 Handle duplicate salaries properly.
		List<Map<String, Double>> hs = companies.stream()
				.sorted(Comparator.comparingDouble(Company::getSalary).reversed())
				.map(c -> Map.of(c.getName(), c.getSalary())).toList();

		Map<String, Double> hs1 = companies.stream().distinct()
				.sorted(Comparator.comparingDouble(Company::getSalary).reversed()).skip(1).findFirst()
				.map(c -> Map.of(c.getName(), c.getSalary())).orElse(Map.of());
		System.out.println("@nd highest sal: " + hs1);

		// change List to map
		Map<String, Double> cmap = companies.stream().collect(Collectors.toMap(Company::getName, Company::getSalary));
		System.out.println("List changed to map: " + cmap);

		// return boolean if salary < 75.00 is found
		Boolean test = companies.stream().anyMatch(c -> c.getSalary() < 75.00);
		System.out.println(" boolean if salary < 75.00 is found:  " + test);

		// Get highest salary company name using reduce()
		Company highest = companies.stream().reduce((c1, c2) -> c1.getSalary() > c2.getSalary() ? c1 : c2)
				.orElse(new Company("", 0.00));
		System.out.println("Highest sal company: " + highest);
//		groupingBy() – Salary Range Grouping
		Map<String, List<Company>> gr= companies.stream().collect(Collectors.groupingBy(c -> {
			double sal = c.getSalary();

            if (sal < 50) return "LOW";
            else if (sal <= 80) return "MEDIUM";
            else return "HIGH";
		}));
		System.out.println("Salary Range: "+gr); 
	}
}