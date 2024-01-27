
public class Pi{
    public static void main(String[]args){
        Fraction MILU = new Fraction(355, 113);
        final double EPSILON = Math.abs(Math.PI - MILU.toDouble());

        while(Math.abs(Math.PI - MILU.toDouble() )>=EPSILON){
            if (Math.PI > MILU.toDouble()){
                MILU= new Fraction(MILU.getNumerator()+1,MILU.getDenominator());
            }else{
                MILU= new Fraction(MILU.getNumerator(),MILU.getDenominator()+1);
            }
        }

        System.out.println("Best approximation:" + MILU);
    }
}

