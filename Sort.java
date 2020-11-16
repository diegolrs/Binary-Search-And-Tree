
public abstract class Sort {
	public abstract void sort(Comparable[] array);
	
	protected static final void swap(int a, int b, Comparable[] array) {
		Comparable temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
}
