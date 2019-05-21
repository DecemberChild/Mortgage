public class Kontroll {
public double Calculation(double Loan,double APR,double Years){

    double Pay= Loan*(1*(APR/100))/(Years*12);

    return Pay;
}
}
