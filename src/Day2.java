import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Application {

	public static void main(String[] args) {
		BufferedReader bufferedReader = null;
		String fileName = "C:\\LocalData\\DIBAIDE\\workspace\\Test\\src\\inputs";
		String line;
		int counter = 0;

		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			while ((line = bufferedReader.readLine()) != null) {
				String[] parts = line.split(" ");
				String[] pos = parts[0].split("-");
				char letter = parts[1].subSequence(0, 1).charAt(0);
				
				char ch1 = parts[2].charAt(Integer.parseInt(pos[0]) - 1);
				char ch2 = parts[2].charAt(Integer.parseInt(pos[1]) - 1);
				if (ch1 != ch2 && (ch1 == letter || ch2 == letter)) {
					counter++;
				}
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
		System.out.println(counter);
	}
}
