package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner kb = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = kb.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = kb.nextLine();
		System.out.print("Level: ");
		String workerLevel = kb.nextLine().toUpperCase();
		System.out.print("Base salary: ");
		double baseSalary = kb.nextDouble();
		var worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker? ");
		int n = kb.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.printf("Enter contract #%d data: \n", i);
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(kb.next());//Captura a data digitada pelo usuario como str e converte para data no formato especificado no sdf
			System.out.print("Value per hour: ");
			double valuePerHour = kb.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = kb.nextInt();
			var contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		
		
		kb.close();
	}
}
