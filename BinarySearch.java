import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BinarySearch {
	public static int getIndex(Comparable key, Comparable[] array) {
		int low = 0;
		int high = array.length;
		
		while(high >= low) {
			int mid = (high + low) / 2;
			
			if(key.compareTo(array[mid]) > 0)
				low = mid + 1;
			else if(key.compareTo(array[mid]) < 0)
				high = mid - 1;
			else
				return mid;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("\n\nUsage: java BinarySearch file1 file2" );
			System.exit(1);
		}
		
		try {
			// Reading first file
	        FileReader in = new FileReader(args[0]);
	        BufferedReader br = new BufferedReader(in);
	        int size = Integer.parseInt(br.readLine());
	        City[] cities = new City[size];
	        
	        String line;
	        StringTokenizer st;        
	        
	        for(int i = 0; i < size; i++) {
	        	line = br.readLine();
	        	st = new StringTokenizer(line);	        	
	        	
	        	cities[i] = new City(st.nextToken(), Float.parseFloat(st.nextToken()));
	        }
	        
	        in.close();
	        br.close();
	        
	        // Sorting
	        Sort sort = new QuickSort();
	        sort.sort(cities);

	        // Second file
	        in = new FileReader(args[1]);
	        br = new BufferedReader(in);
	        size = Integer.parseInt(br.readLine());
	        
	        for(int i = 0; i < size; i++) {
	        	line = br.readLine();
	        	st = new StringTokenizer(line);
	        	String name = st.nextToken();
	        	
	        	int position = BinarySearch.getIndex(new City(name, 0), cities);
	        	
	        	if(position < 0)
	        		System.out.println("[Failed] " + name + "wasn't found.");
	        	else
	        		System.out.println("[Ok] " + name + " was found at position " + position + ".");
	        }
	        
		}catch(IOException err) {}
		
	}
	
}






