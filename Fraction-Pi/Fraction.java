/**
 * Class Fraction.
 *
 * @Lisa Dai
 * @version 1.0
 * @param numerator, a numerator of the returned fraction.
 * @param denominator, a denominator of the returned fraction.
 *
 */
import java.util.Scanner;
public class Fraction{
    //Instance Variable
    private int numerator,denominator;
    private String numeratorString=String.valueOf(numerator);  
    private  String denominatorString=String.valueOf(denominator);  

    //Constructors
    /*
     * Default constructor
     * A Fraction object with randomly declared initial value
     */
    public Fraction(){
        int numerator=(int)Math.random()*20;
        int demoninator=(int)Math.random()*20;
    }

    /*
     * Parameterized constructor
     * @param numeratorValue,the desired numerator.
     * @param denominatorValue, the desired denominator.
     * A Fraction object takes two int parameters.
     */
    public Fraction(int numeratorValue,int denominatorValue){
        numerator=numeratorValue;
        denominator=denominatorValue;
    }

    /*
     * Fraction constructor
     * A fraction object that represents a fraction using a forward slash character.
     * @param farc, the fracrtion in string format.
     */
    public Fraction(String frac){
        int slashIndex=frac.indexOf("/");
        if (slashIndex>0){
            String n=frac.substring(0,slashIndex);
            String d=frac.substring(slashIndex+1);
            numerator=Integer.parseInt(n);
            denominator= Integer.parseInt(d);
            fixDenominator();
        }
    }

    /*
     * Copy ocnstructor
     * @param frac, the fraction object to copy.
     * A fraction object that creates a new fraction that has the same numerator and denominator.
     */
    public Fraction(Fraction frac){
        numerator=frac.numerator;
        denominator=frac.denominator;
        fixDenominator();
    }
    //Behaviour Methods
    /*
     * Method for limiting the denominator to a non-zero number.
     */
    private void fixDenominator(){
        if(denominator==0){
            System.out.println("Error:denoiminator can not be 0, change to 1");
            denominator=1;
        }
    }
    //Accessor Methods
    /*
     * Method to return a numerator in int format.
     */
    public int getNumerator(){
        return numerator;
    }

    /*
     * Method to return an denominator in int format.
     */
    public int getDenominator(){
        return denominator;
    }

    /*
     * Method to return a fraction in string format.
     */
    public String toString(){
        return numerator+"/"+denominator;
    }

    /*
     * Method to return an fraction in double format.
     */
    public double toDouble(){
        return (double) numerator/denominator;
    }

    //GCF
    /*
     * Greatest Common Factor Method 
     * @param int a, any possible number in int format.
     * @param int b, any possible number in int format.
     * Method to find the greatest common factor of two numbers in int format.
     */
    private int gcd(int a,int b){
        while(a!=b){
            if(a>b){
                return a-b;
            }
            if(b>a){
                return b-a;
            }else{
                return 0;
            }
        }
        return 0;
    }
    //Mutator Method
    /*
     *Method for reducing the Fraction object to lowest terms.  
     */
    public void reduce(){
        numerator=numerator/gcd(numerator,denominator);
        denominator=denominator/gcd(numerator,denominator);
    }

    /*
     *Method for changing the values of the numerator.
     */
    public void setNumerator(int num){
        numerator=num;
    }

    /*
     * Method for changing the values of the denominator
     */
    public void setDenominator(int denom){
        denominator=denom;
        fixDenominator();
    }

    //Static
    private static int findGcf(int a, int b){
        while(a!=b){
            if(a>b){
                return a - b;
            }
            if(b>a){
                return b-a;
            }else{
                return 0;
            }
        }
        return 0;
    }

    /*
     * Method for returning a new Fraction object that applies substraction operation of two Fraction objects.
     * @param Fraction n, the fraction object to be multiplied.
     * @param Fraction d, the fraction object to be multiplied.
     */
    public static Fraction multiply(Fraction n,Fraction d){
        int nProductComplex=n.getNumerator()*d.getNumerator();
        int dProductComplex=n.getDenominator()*d.getDenominator();
        int x =findGcf(nProductComplex, dProductComplex);
        int nProduct=nProductComplex/x;
        int dProduct=dProductComplex/x;
        Fraction product=new Fraction(nProduct, dProduct);
        return product;
    }

    /*
     * Method for returning a new Fraction object that applies division operation of two Fraction objects.
     * @param Fraction n, the fraction object as a dividend.
     * @param Fraction d, the fraction object as a divisor.
     */
    public static Fraction divide(Fraction n,Fraction d){
        int nQuotientComplex=n.getNumerator()*d.getDenominator();
        int dQuotientComplex=n.getDenominator()*d.getNumerator();
        int x =findGcf(nQuotientComplex,dQuotientComplex); 
        int nProduct=nQuotientComplex/x;
        int dProduct=dQuotientComplex/x;
        Fraction quotient= new Fraction(nProduct, dProduct);
        return quotient;
    }

    /*
     * Method for returning a new Fraction object that applies addition operation of two Fraction objects.
     * @param Fraction n, the fraction object to be added with Fraction d.
     * @param Fraction d, the fraction object to be added with Fraction n.
     */
    public static Fraction add(Fraction n,Fraction d){
        int nSumComplex=n.getNumerator()*d.getDenominator()+d.getNumerator()*n.getDenominator();
        int dSumComplex=n.getDenominator()*d.getDenominator();
        int x=findGcf(nSumComplex,dSumComplex); 
        int nProduct=nSumComplex/x;
        int dProduct=dSumComplex/x;
        Fraction sum= new Fraction(nProduct, dProduct);
        return sum;
    }

    /*
     * Method for returning a new Fraction object that applies subtraction operation of two Fraction objects.
     * @param Fraction n, the fraction object as a minuend.
     * @param Fraction d, the fraction object as a subtrahend.
     */
    public static Fraction subtract(Fraction n,Fraction d){
        int nDifferenceComplex=n.getNumerator()*d.getDenominator()-d.getNumerator()*n.getDenominator();
        int dDifferenceComplex=n.getDenominator()*d.getDenominator();
        int x=findGcf(nDifferenceComplex,dDifferenceComplex); 
        int nProduct=nDifferenceComplex/x;
        int dProduct=nDifferenceComplex/x;
        Fraction difference=new Fraction(nProduct, dProduct);
        return difference;
    }
    public boolean equals(Fraction f){
        return (this.getNumerator()==f.getNumerator()&&this.getDenominator()==f.getDenominator());
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Fraction randomFraction1= new Fraction();
        Fraction randomFraction2= new Fraction();
        //generate random operator
        int operatorCode = (int)Math.random()*3;
        String[] operators = {"+", "-", "*", "/"};
        String operator = operators[operatorCode];
        //actual answer
        Fraction answer= new Fraction();
        if(operatorCode==0){
            answer=add(randomFraction1,randomFraction2);
        }
        if(operatorCode==1){
            answer=subtract(randomFraction1,randomFraction2);
        }
        if(operatorCode==2){
            answer=multiply(randomFraction1,randomFraction2);
        }
        if(operatorCode==3){
            answer=divide(randomFraction1,randomFraction2);
        }
        System.out.println("Let the Fraction Quiz Begin. Answers should be in lowest terms. Good luck!");
        System.out.println(randomFraction1+operator+randomFraction2+"=");
        
        scanner.nextLine();

    }
    
    
}

