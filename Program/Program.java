package program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner leitor = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Between contract data: ");
		System.out.print("Number: ");
		int number = leitor.nextInt();
		System.out.print("Date: ");
		LocalDate date = LocalDate.parse(leitor.next(), dtf);
		System.out.print("Contract value: ");
		double totalValue = leitor.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Enter the number of installments: ");
		int n = leitor.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, n);
		
		System.out.println("Installments: ");
		for(Installment installment: contract.getInstalments()) {
			System.out.println(installment);
		}
		
		
		
		leitor.close();
	}

}
