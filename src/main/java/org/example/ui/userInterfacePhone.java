package org.example.ui;

import org.example.Service.PersonService;
import org.example.Service.PhoneService;
import org.example.Service.PhoneServiceImpl;
import org.example.dao.PhoneDao;
import org.example.dao.PhoneDaoImpl;
import org.example.entity.Phone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;
@Configuration
@ComponentScan(basePackages = "org.example")
public class userInterfacePhone {
//    @Bean
//    public PhoneDao getphonedao()
//    {
//        return new PhoneDaoImpl();
//    }
//    public PhoneService getphoneser(PhoneDao getphonedao)
//    {
//        new PhoneServiceImpl(getphonedao);
//    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ApplicationContext ctx=new AnnotationConfigApplicationContext(userInterfacePhone.class);
        PhoneService ps=ctx.getBean(PhoneService.class);


        while (true) {


            System.out.println("1. Display All Phones");
            System.out.println("2. Add Phone");
            System.out.println("3. Sort By Price Asc");
            System.out.println("4. Sort By Price Desc");
            System.out.println("5. Filter By Brand");
            System.out.println("6. Filter By Min Price");
            System.out.println("7. Filter By Max Price");
            System.out.println("8.find phone by id");
            System.out.println("9. Exit");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1:
                    ps.findAll().forEach(System.out::println);
                    break;

                case 2:
                    System.out.println("Enter Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter Brand:");
                    String brand = sc.nextLine();

                    System.out.println("Enter Price:");
                    double price = sc.nextDouble();

                    System.out.println("Enter Camera MP:");
                    int cam = sc.nextInt();

                    ps.addPhone(new Phone(name, brand, price, cam));
                    break;

                case 3:
                    ps.sortByPriceAsc().forEach(System.out::println);
                    break;

                case 4:
                    ps.sortByPriceDesc().forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Enter Brand:");
                    String b = sc.nextLine();
                    ps.filterByBrand(b).forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Enter Min Price:");
                    double min = sc.nextDouble();
                    ps.filterByMinPrice(min).forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Enter Max Price:");
                    double max = sc.nextDouble();
                    ps.filterByMaxPrice(max).forEach(System.out::println);
                    break;
                case 8:
                    System.out.println("enter id to search for phone");
                    int i=sc.nextInt();
                    Phone p1=ps.findPhoneById(i);
                    System.out.println(p1);
                    break;

                case 9:
                    System.exit(0);

            }
        }
    }
}

