public class Ej11 {
    public static void main(String[] args) {
        for (int i = 1; i <=5000 ; i++) {
            var numString = String.valueOf(i);
            var numArray = numString.toCharArray();
            int[] intArray = new int[numArray.length];
            //Comprobar suma de cubos
            var suma=0;
            for(int j=0;j<intArray.length;j++){
                intArray[j] = Character.getNumericValue(numArray[j]);
                suma += Math.pow(intArray[j], 3);
            }
            
            if(suma==i){
                System.out.println(i);
            }
        }
    }
}
