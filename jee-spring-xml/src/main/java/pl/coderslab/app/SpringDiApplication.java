package pl.coderslab.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.coderslab.beans.EmailService;
import pl.coderslab.beans.HelloWorld;
import pl.coderslab.beans.MessageSender;
import pl.coderslab.beans.MessageService;

public class SpringDiApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        HelloWorld helloWorld = ctx.getBean("helloWorld", HelloWorld.class);
        helloWorld.printMessage();
        System.out.println(helloWorld.getMessage());

        HelloWorld helloWorld1 = (HelloWorld) ctx.getBean("helloWorld");
        helloWorld1.printMessage();

        HelloWorld helloWorld2 = ctx.getBean(HelloWorld.class);
        helloWorld2.printMessage();

        System.out.println(helloWorld.getMessage());

        MessageService messageService = (EmailService) ctx.getBean("emailService");
        messageService.send();

        MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);
        messageSender.sendMessage();
        messageSender.sendMessageFromProperty();

        ctx.close();
    }

}
