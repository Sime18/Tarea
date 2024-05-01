package Generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		// Leer archivos de vendedores
		List<List<String>> productsInfo = Utils.readCsv("productsFile");

		File csvFile = new File("salesManReport.csv");
		FileWriter fileWriter = new FileWriter(csvFile);

		fileWriter.write("IDVendedor;NombreVendedor;CantidadRecaudada\n");
		
		HashMap<String, Integer> allProductsQty = new HashMap<>();

		for (Integer i = 0; i < Utils.totalSalesMen; i++) {

			List<List<String>> records = Utils.readCsv("salesMan_" + i);
			HashMap<String, Integer> data = new HashMap<>();

			for (Integer j = 1; j < records.size(); j++) {
				String productId = records.get(j).get(2);
				String quantity = records.get(j).get(3);

				if (data.get(productId) == null) {
					data.put(productId, Integer.parseInt(quantity));
				} else {
					int oldQty = data.get(productId);
					data.put(productId, Integer.parseInt(quantity) + oldQty);
				}
				
				
			}

			ArrayList<String> soldProductIds = new ArrayList<>(data.keySet());
			long totalSold = 0;

			for (Integer j = 0; j < soldProductIds.size(); j++) {
				String productId = soldProductIds.get(j);
				List<String> productInfo = productsInfo.get(Integer.parseInt(productId) + 1);
				long productPrice = Long.parseLong(productInfo.get(2));

				totalSold += data.get(productId) * productPrice;
				
				//Suma las cantidades vendidas del producto
				if (allProductsQty.get(productId) == null) {
					allProductsQty.put(productId, data.get(productId));
				} else {
					int oldQty = allProductsQty.get(productId);
					allProductsQty.put(productId, data.get(productId) + oldQty);
				}

			}
			
			StringBuilder line = new StringBuilder();

			line.append(records.get(i+1).get(0));
			line.append(Utils.DELIMITER);
			line.append(records.get(i+1).get(1));
			line.append(Utils.DELIMITER);
			line.append(totalSold);
			line.append("\n");

			fileWriter.write(line.toString());
			
			totalSold = 0;

			
		}
		
		//Crear archivo con datos de productos vendidos
		File csvFile2 = new File("productReport.csv");
		FileWriter fileWriter2 = new FileWriter(csvFile2);
		ArrayList<String> productIds = new ArrayList<>(allProductsQty.keySet());

		fileWriter2.write("IDProducto;TotalVendido\n");
		
		System.out.println(allProductsQty);
		for(int i = 0; i < allProductsQty.size(); i++) {
			int qty = allProductsQty.get(Integer.toString(i));		
			System.out.println(productIds.get(i));
			System.out.println(qty);
			StringBuilder line = new StringBuilder();
			
			line.append(productIds.get(i));
			line.append(Utils.DELIMITER);
			line.append(qty);
			line.append("\n");
			
			fileWriter2.write(line.toString());
		}
		
		
		
		fileWriter.close();
		fileWriter2.close();

	}
}
