package sqa.lab;

public class Main {

	public static void main(String[] args) {
		UniversalConverter converter = new UniversalConverter();
		System.out.println(converter.convert(1,"Weight", "once", "gram"));
		System.out.println(converter.convert(1,"Temperature", "K", "C"));

	}

}
