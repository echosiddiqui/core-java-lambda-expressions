package com.lambda.apps.stream;

import com.lambda.apps.model.Company;
import com.lambda.apps.model.Laptop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaInStream {

	private static List<Laptop> laptopList = new ArrayList<>(
			Arrays.asList(
					new Laptop("HP", 800),
					new Laptop("Apple", 1200),
					new Laptop("Dell", 500)
			)
	);

	public static void main(String[] args) {

		laptopList.forEach(System.out::println);

		System.out.println("\n-----Use of filter() in Stream-----");
		laptopList.stream()
			.filter(l -> !l.getBrand().startsWith("M"))
			.forEach(System.out::println); // <-- Terminal operation of Stream, no Intermediate operation can be done after this

		System.out.println("\n-----Use of findAny() & findFirst() in Stream-----");
		Laptop laptop = laptopList.stream()
				.filter(l -> l.getBrand().startsWith("M"))
				.findAny()
//				.findFirst()
				.orElse(null);
		System.out.println(laptop);

		System.out.println("\n-----Ex 1: Use of map() in Stream-----");
		/** map() is generally used to convert stream of one object to another */
		List<String> brandList = laptopList.stream()
				.map(l -> l.getBrand().toUpperCase())
				.collect(Collectors.toList());
		System.out.println(brandList);

		System.out.println("\n-----Ex 2: Use of map() in Stream-----");
		List<Company> stringList = laptopList.stream()
				.map(l -> l.getBrand())
				.map(Company::new)
				.collect(Collectors.toList());
		System.out.println(stringList);
	}

}