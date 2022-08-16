
public class Main{
  
	public static void main(String [] args) throws Exception{
	  
		Money money = new Money(10, 50);
		System.out.println("Money value: " + money.getMoney());
		money.add(10);
		System.out.println(money.toString());
		money.add(new Money(10));
		System.out.println(money.toString());
		System.out.println();
		Date date = new Date(10, 16, 2015);
		System.out.println("Date value :" + date.toString());
		System.out.println("Is date before 10-17-2015? " + date.before(new Date(10, 17, 2015)));
		System.out.println("Is date after 10-17-2015? " + date.isAfter(new Date(10, 17, 2015)));
		System.out.println();
		Bill bill = new Bill(money, date, "dummyOriginator");
		System.out.println( bill.toString());
		bill.setAmount(new Money(40));
		System.out.println( bill.toString());
		bill.setPaid(new Date(10,16,2014));
		System.out.println( bill.toString());
	}

}