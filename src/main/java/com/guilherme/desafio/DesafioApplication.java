package com.guilherme.desafio;

import com.guilherme.desafio.entities.Order;
import com.guilherme.desafio.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	private OrderService orderService;

	public DesafioApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order = new Order();

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Código do pedido: ");
		order.setCode(sc.nextInt());
		System.out.print("Valor básico do pedido: ");
		order.setBasic(sc.nextDouble());
		System.out.print("Desconto em porcentagem: ");
		order.setDiscount(sc.nextDouble());

		System.out.println("Código do pedido: " + order.getCode());
		System.out.printf("Total: %.2f%n", orderService.total(order));

		sc.close();
	}
}