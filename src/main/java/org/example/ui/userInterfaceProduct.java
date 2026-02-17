package org.example.ui;

import org.example.Service.ProductService;
import org.example.entity.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;
@Configuration
@ComponentScan(basePackages = "org.example")
public class userInterfaceProduct {
//    @Bean
//    public ProductDao getpdao()
//    {
//        return new ProductDaoimpl();
//    }
//    @Bean
//    public ProductService getproduct(ProductDao getpdao)
//    {
//        return new ProductServiceImpl(getpdao);
//
//    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        ProductDao dao = new ProductDaoimpl();
        ApplicationContext ctx=new AnnotationConfigApplicationContext(userInterfaceProduct.class);
        ProductService dao=ctx.getBean(ProductService.class);

        while (true) {

            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Display All Products");
            System.out.println("2. Add Product");
            System.out.println("3. Sort By Cost Ascending");
            System.out.println("4. Sort By Cost Descending");
            System.out.println("5. Sort By Discount Ascending");
            System.out.println("6. Sort By Discount Descending");
            System.out.println("7. Sort By Rating");
            System.out.println("8. Filter By Name");
            System.out.println("9. Filter By Brand");
            System.out.println("10. Filter By Category");
            System.out.println("11. Filter By Min Cost");
            System.out.println("12. Filter By Max Cost");
            System.out.println("13.check for existence");
            System.out.println("14. Exit");

            System.out.println("Enter choice:");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    dao.findAll().forEach(System.out::println);
                    break;

                case 2:
                    System.out.println("Enter Product Name:");
                    String name = sc.next();

                    System.out.println("Enter Cost:");
                    double cost = sc.nextDouble();

                    System.out.println("Enter Brand:");
                    String brand = sc.next();

                    System.out.println("Enter Category:");
                    String category = sc.next();

                    System.out.println("Enter Rating:");
                    int rating = sc.nextInt();

                    System.out.println("Enter Discount Percentage:");
                    int discount = sc.nextInt();

                    Product product = new Product(name, cost, brand, category, rating, discount);
                    dao.addProduct(product);
                    System.out.println("Product Added Successfully!");
                    break;

                case 3:
                    dao.sortByCostAscending().forEach(System.out::println);
                    break;

                case 4:
                    dao.sortByCostDescending().forEach(System.out::println);
                    break;

                case 5:
                    dao.sortByDiscountAscending().forEach(System.out::println);
                    break;

                case 6:
                    dao.sortByDiscountDescending().forEach(System.out::println);
                    break;

                case 7:
                    dao.sortByRating().forEach(System.out::println);
                    break;

                case 8:
                    System.out.println("Enter Name:");
                    String fname = sc.next();
                    dao.filterByName(fname).forEach(System.out::println);
                    break;

                case 9:
                    System.out.println("Enter Brand:");
                    String brand2 = sc.next();
                    dao.filterByBrand(brand2).forEach(System.out::println);
                    break;

                case 10:
                    System.out.println("Enter Category:");
                    String fcat = sc.next();
                    dao.filterByCategory(fcat).forEach(System.out::println);
                    break;

                case 11:
                    System.out.println("Enter Minimum Cost:");
                    double min = sc.nextDouble();
                    dao.filterByMinCost(min).forEach(System.out::println);
                    break;

                case 12:
                    System.out.println("Enter Maximum Cost:");
                    double max = sc.nextDouble();
                    dao.filterByMaxCost(max).forEach(System.out::println);
                    break;
                case 13:
                    System.out.println("enter id to check if it is exist or not");
                    int id=sc.nextInt();
                    if(dao.existid(id))
                    {
                        System.out.println("yes");
                    }
                    else{
                        System.out.println("no");
                    }



                case 14:
                    System.out.println("Exiting");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
