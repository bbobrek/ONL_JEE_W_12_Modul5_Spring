package pl.coderslab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.HelloWorld;
import pl.coderslab.beans.ScopePrototype;
import pl.coderslab.beans.ScopeSingleton;
import pl.coderslab.beans.Ship;

public class SpringDiApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld helloWorld = ctx.getBean("helloWorld", HelloWorld.class);
        HelloWorld helloWorld1 = ctx.getBean(HelloWorld.class);

        helloWorld.hello();

        Ship ship = ctx.getBean("blackPearl", Ship.class);
        ship.getCaptain().startSailing();

        ScopeSingleton singleton1 = ctx.getBean(ScopeSingleton.class);
        System.out.println(singleton1);
        ScopeSingleton singleton2 = ctx.getBean(ScopeSingleton.class);
        System.out.println(singleton2);
        System.out.println((singleton1 == singleton2) + ": ten sam obiekt\n");
        ScopePrototype prototype1 = ctx.getBean(ScopePrototype.class);
        System.out.println(prototype1);
        ScopePrototype prototype2 = ctx.getBean(ScopePrototype.class);
        System.out.println(prototype2);
        System.out.println((prototype1 == prototype2) + ": dwa różne obiekty");
        
        ctx.close();
    }

}
