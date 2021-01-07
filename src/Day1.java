import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

	public static void main(String[] args) {
		BufferedReader bufferedReader = null;
		String fileName = "C:\\LocalData\\DIBAIDE\\workspace\\Test\\src\\inputs";
		List<Integer> reports = new ArrayList<>();

		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			String digit;
			while ((digit = bufferedReader.readLine()) != null) {
				reports.add(Integer.valueOf(digit));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		List<Long> results = new ArrayList<>();
		List<Integer> sortedReports = reports.stream().sorted().collect(Collectors.toList());

		for (Integer report : sortedReports) {
			Integer first = report;
			for (Integer report2 : reports) {
				Integer remain = 2020 - report + report2;
				int i = Collections.binarySearch(sortedReports, remain);
				Integer report3 = (i < 0 || i >= 200) ? -1 : sortedReports.get(i);
				if (first + report2 + report3 == 2020) {
					results.add((long) (first * report2 * report3));
				}
			}
		}

		results.forEach(System.out::println);
	}
}
