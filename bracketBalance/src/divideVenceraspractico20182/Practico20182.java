package divideVenceraspractico20182;

public class Practico20182 {

	public int recursivo(int[] arr, int menor, int mayor) {
		//Caso basee
		if(menor == mayor) {
			return menor;
			
		}else {
			//Division
			int mitad = (menor+mayor)/2;
			int i1 = recursivo(arr, mitad+1, mayor);
			int i2 = recursivo(arr,0,mitad);
			
			//Combinacion
			if(arr[i1]<arr[i2]) {
				return i1;
			}else {
				return i2;
			}
		}
	}
	
	public static void main(String[] args) {
		Practico20182 p = new Practico20182();
		int[] arreglo = {7,9,11,12,5};
		int indice = p.recursivo(arreglo,0,arreglo.length-1);
		int retorno = arreglo.length - indice;
		if(retorno == arreglo.length) {
			retorno = 0;	
		}
		System.out.println(retorno);
	}
	
	
}
