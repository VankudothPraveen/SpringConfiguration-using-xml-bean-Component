package org.example.ui;

import org.example.Service.PersonService;
import org.example.Service.PersonServiceImpl;
import org.example.dao.PersonDao;
import org.example.dao.PersonDaoImpl;
import org.example.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Configuration
@ComponentScan(basePackages = "org.example")
public class userInterface {
//    @Bean
//    public PersonDao getPersondao()
//    {
//        return new PersonDaoImpl();
//    }
//    @Bean
//    public PersonService getpersonSer(PersonDao getPersondao)
//    {
//        return new PersonServiceImpl(getPersondao);
//    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
//        PersonDao pdao=new PersonDaoImpl();
//        ApplicationContext ctx=new AnnotationConfigApplicationContext(userInterface.class);
//        PersonService pdao=ctx.getBean(PersonService.class);
        ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        PersonService pdao=(PersonService) ctx.getBean("personService");
        while(true)
        {
            System.out.println("1.find all details in praveen table");
            System.out.println("2.add person");
            System.out.println("3.delete by id");
            System.out.println("4.find by id");
            System.out.println("5.findbyFnameContaining");
            System.out.println("6.findsortedbyfname");
            System.out.println("7.exist id");
            System.out.println("8.exit");
            System.out.println("enter choice");
            int  choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:

                    pdao.findAll().stream().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("enter fanme");
                    String fname=sc.nextLine();

                    System.out.println("enter lname");
                    String lname=sc.nextLine();
                    pdao.addPerson(new Person(fname,lname));
                    break;
                case 3:
                    System.out.println("enter person id to delete");
                    int id=sc.nextInt();
                    pdao.deleteById(id);
                    break;
                case 4:
                    System.out.println("enter person id to find");
                    int x=sc.nextInt();
                    System.out.println(pdao.findById(x));
                    break;
                case 5:
                    System.out.println("enter string for matchig");
                    String str=sc.next();
                    pdao.findByFnameContaining(str).stream().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Sorted by Fname");
                    pdao.findSortedByFname().stream().forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("enter person id to check");
                    int y=sc.nextInt();
                   if( pdao.existId(y))
                   {
                       System.out.println("Yes id exist");
                   }else{
                       System.out.println("no id exist");
                   }
                   break;
                case 8:
                    System.exit(0);
            }
        }



    }
}
