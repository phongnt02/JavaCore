package org.example.spring_beans_define;

import org.example.spring_beans_define.configs.AppConfigAnnotation;
import org.example.spring_beans_define.configs.AppConfigJava;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringBeansDefineApplication {

	public static void main(String[] args) {
		System.out.println("Using XML Configuration");
		ApplicationContext contextXml = new ClassPathXmlApplicationContext("beans.xml");
		org.example.spring_beans_define.services.xml.PaymentProcessor paymentProcessorXml =
				contextXml.getBean(org.example.spring_beans_define.services.xml.PaymentProcessor.class);
		paymentProcessorXml.process(100.0);


		System.out.println("Using Annotation Configuration");
		ApplicationContext contextAnnotation = new AnnotationConfigApplicationContext(AppConfigAnnotation.class);
		org.example.spring_beans_define.services.anotation.PaymentProcessor paymentProcessorAnnotation =
				contextAnnotation.getBean(org.example.spring_beans_define.services.anotation.PaymentProcessor.class);
		paymentProcessorAnnotation.process(200.0);


		System.out.println("Using Java Configuration");
		ApplicationContext contextJava = new AnnotationConfigApplicationContext(AppConfigJava.class);
		org.example.spring_beans_define.services.java_configuration.PaymentProcessor paymentProcessorJava =
				contextJava.getBean(org.example.spring_beans_define.services.java_configuration.PaymentProcessor.class);
		paymentProcessorJava.process(300.0);

		// Close context to trigger destroy methods
		((ClassPathXmlApplicationContext) contextXml).close();
		((AnnotationConfigApplicationContext) contextAnnotation).close();
		((AnnotationConfigApplicationContext) contextJava).close();
	}
}
