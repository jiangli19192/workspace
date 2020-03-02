import java.math.BigDecimal;



public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal money1 = new BigDecimal("10");
		BigDecimal money2 = new BigDecimal("10");
		
		if (money1.compareTo(money2) < 0) {
			System.out.println("money1 小于 money2");
		} else if (money1.compareTo(money2) > 0) {
			System.out.println("money1 大于 money2");
		} else if (money1.compareTo(money2) == 0) {
			System.out.println("money1 等于 money2");
		}
	}
}
