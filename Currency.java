import static java.lang.System.*;
import java.text.*;
import java.util.Locale;


public class Currency{


	public static void main(String[] args){


		NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		double c = 59.99321;
		out.println(cf.format(c));


		double d = 1234567.437;
		DecimalFormat one = new DecimalFormat("###,###,###.###");
		System.out.println(one.format(d));
		DecimalFormat two = new DecimalFormat("000,000,000.00000");
		System.out.println(two.format(d));
		DecimalFormat three = new DecimalFormat("$#,###,###.##");
		System.out.println(three.format(d));



	}


}
