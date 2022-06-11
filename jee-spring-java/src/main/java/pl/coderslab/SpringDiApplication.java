package pl.coderslab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.HelloWorld;

public class SpringDiApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld helloWorld = ctx.getBean("helloWorld", HelloWorld.class);
        HelloWorld helloWorld1 = ctx.getBean(HelloWorld.class);

        helloWorld1.hello();

        ctx.close();
    }

}
