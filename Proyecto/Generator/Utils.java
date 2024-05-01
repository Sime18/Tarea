package Generator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
	static String DELIMITER = ";";
	static int totalProducts = 10;
	static int totalSalesMen = 10;
	static int totalSalesRecords = 10;
	
	static List<List<String>> readCsv(String fileName) throws FileNotFoundException, IOException {
		List<List<String>> records = new ArrayList<>();
		new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName + ".csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(DELIMITER);
				records.add(Arrays.asList(values));
			}
		}

		return records;
	}
}
