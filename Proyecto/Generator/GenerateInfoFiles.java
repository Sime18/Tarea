package Generator;


import java.io.IOException;

public class GenerateInfoFiles {
	public static void main(String[] args) throws IOException {
		Generators.createProductFile(10);
		Generators.createSalesManInfoFile(10);
		Generators.createSalesMenFile(10, "Daniel", 1088354969);
		Generators.createSalesMenFileSecond(10, "Daniel", 12);
	}
}
