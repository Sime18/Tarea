package Generator;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Generators {
	static int totalProducts = 1;
	final static String separator = ";";

	public static void createProductFile(int productsCount) throws IOException {

		totalProducts = productsCount;

		File csvFile = new File("productsFile.csv");
		FileWriter fileWriter = new FileWriter(csvFile);

		fileWriter.write("IDProducto;NombreProducto;PrecioUnidad\n");

		for (int i = 0; i < productsCount; i++) {
			StringBuilder line = new StringBuilder();

			line.append(i);
			line.append(separator);
			line.append("Producto " + i);
			line.append(separator);
			line.append(getRandomNumber(5000, 35000));
			line.append("\n");

			fileWriter.write(line.toString());
		}

		fileWriter.close();
	}

	public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {

		File csvFile = new File("salesMenFile.csv");
		FileWriter fileWriter = new FileWriter(csvFile);

		fileWriter.write("IDVendedor;NombreVendedor;IDProducto\n");

		for (int i = 0; i < randomSalesCount; i++) {
			StringBuilder line = new StringBuilder();

			line.append(id);
			line.append(separator);
			line.append(name);
			line.append(separator);
			line.append(getRandomNumber(0, totalProducts - 1));
			line.append("\n");

			fileWriter.write(line.toString());
		}

		fileWriter.close();
	}
	
	public static void createSalesMenFileSecond(int randomSalesCount, String name, long id) throws IOException {

		File csvFile = new File("salesMenFileSecond.csv");
		FileWriter fileWriter = new FileWriter(csvFile);

		fileWriter.write("IDVendedor;NombreVendedor;IDProducto;CantidadVendida\n");

		for (int i = 0; i < randomSalesCount; i++) {
			StringBuilder line = new StringBuilder();

			line.append(id);
			line.append(separator);
			line.append(name);
			line.append(separator);
			line.append(getRandomNumber(0, totalProducts - 1));
			line.append(separator);
			line.append(getRandomNumber(1, 150));
			line.append("\n");

			fileWriter.write(line.toString());
		}

		fileWriter.close();
	}

	public static void createSalesManInfoFile(int salesmanCount) throws IOException {
		List<String> names = Arrays.asList("Alejandro", "Andrea", "Carlos", "Carmen", "Daniel", "Daniela", "Eduardo",
				"Elena", "Fernando", "Isabel", "Javier", "Jimena", "José", "Julia", "Luis", "Lucía", "Manuel", "María",
				"Miguel", "Marta", "Óscar", "Olivia", "Pablo", "Paula", "Rafael", "Sara", "Sergio", "Sofía", "Víctor",
				"Valeria");

		List<String> lastnames = Arrays.asList("García", "González", "Rodríguez", "Fernández", "López", "Martínez",
				"Sánchez", "Pérez", "Gómez", "Martín", "Jiménez", "Ruiz", "Hernández", "Díaz", "Moreno", "Muñoz",
				"Álvarez", "Romero", "Alonso", "Gutiérrez", "Navarro", "Torres", "Domínguez", "Vázquez", "Ramos", "Gil",
				"Ramírez", "Serrano", "Blanco", "Molina");
		
		List<String> docTypes = Arrays.asList("CC", "CE");
		
		
		File csvFile = new File("salesManIntoFile.csv");
		FileWriter fileWriter = new FileWriter(csvFile);

		fileWriter.write("TipoDocumento;NumeroDocumento;Nombres;Apellidos\n");

		for (int i = 0; i < salesmanCount; i++) {
			StringBuilder line = new StringBuilder();

			line.append(docTypes.get(getRandomNumber(0, 1)));
			line.append(separator);
			line.append(Long.toString(1088324456 + i));
			line.append(separator);
			line.append(names.get(getRandomNumber(0, 29)));
			line.append(separator);
			line.append(lastnames.get(getRandomNumber(0, 29)) + " " + lastnames.get(getRandomNumber(0, 29)));
			line.append("\n");

			fileWriter.write(line.toString());
		}

		fileWriter.close();

	}

	private static int getRandomNumber(int min, int max) {
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}

}
