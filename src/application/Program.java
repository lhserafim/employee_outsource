package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String args[]) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        for(int i=1; i<=n; i++) {
            System.out.println("Employee #" + i + " data:");
            System.out.print("Outsourced (y/n)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            if(ch == 'y') {
                System.out.print("Additional charge: ");
                Double additionalCharge = sc.nextDouble();
                // modo explicito
                // instanciar e adicionar a lista
                Employee emp = new OutsourcedEmployee(name,hours,valuePerHour,additionalCharge);
                list.add(emp);
            }
            else{
                //modo implicito
                //Adiciona instanciando
                list.add(new Employee(name,hours,valuePerHour));
            }
        }
        System.out.println();
        System.out.println("PAYMENTS:");
        // for each
        for(Employee c : list) {
            System.out.println(c.getName() + " - $ " + String.format("%.2f", c.payment()));
        }

        sc.close();
    }
}
