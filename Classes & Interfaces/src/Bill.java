import java.io.Serializable;

class Bill implements Comparable<Bill>, Cloneable, Serializable
{
	
	private static final long serialVersionUID = 7432328721914607555L;
	//Declare variables
	private Money amount;
	private Date dueDate;
	private Date paidDate;
	private String originator;
	public Bill(Money amount, Date dueDate, String originator)
	{//Constructor for instance variables
		this.amount = amount;
		this.dueDate = dueDate;
		this.originator = originator;
		this.paidDate = null;
	}
	//Defines constructor
	public Bill(Bill toCopy)
	{
		this.amount = toCopy.amount;
		this.dueDate = toCopy.dueDate;
		this.originator = toCopy.originator;
		this.paidDate = toCopy.paidDate;
	}
	
	public Date getDueDate() throws Exception
	{//Gets due date
		if(paidDate == null)
		return dueDate;
		else if(paidDate.isAfter(dueDate))
		throw new Exception("The due date is before the paid date.");
		else
		return dueDate;
	}
	
	public String getOriginator()
	{
		return originator;
	}
	
	public boolean isPaid()
	{
		if(paidDate != null)
		return true;
		else
		return false;
	}
	
	boolean setPaid(Date onDay) throws Exception
	{//if datePaid is after the dueDate, the call does not update anything and returns false.
		if(onDay.before(dueDate))
		this.paidDate = onDay;
		else throw new Exception("The paid date is after the due date.");
		return true;
	}
	
	public void setUnpaid()
	{
		this.paidDate = null;
	}
	
	public void setDueDate(Date nextDate) throws Exception
	{
		if(nextDate.isAfter(paidDate))
		this.dueDate = nextDate;
		else
		throw new Exception("The due date is before the paid date.");
	}
	
	public void setAmount(Money amount)
	{
		this.amount = amount;
	}
	
	public Money getAmount()
	{
		return new Money(amount);
	}
	
	public void setOriginator(String originator)
	{
		this.originator = originator;
	}
	
	public String toString()
	{//Builds a string that reports the amount, when due, to whom, if paid, and if date paid
		String value = "An amount of " + amount + " is due on " + dueDate + " and ";
		if(paidDate == null)
		value += "is still not yet paid.";
		else
		value += "was paid on " + paidDate;
		return value;
	}
	
	public boolean equals(Bill toCompare)
	{//Returns if the two objects are the same
	if(toCompare.amount == this.amount && toCompare.dueDate == this.dueDate && toCompare.paidDate
	== this.paidDate && this.originator == toCompare.originator)
	return true;
	else
	return false;
	}
	@Override
	public int compareTo(Bill o) {
		if (getClass() != o.getClass())
		throw new IllegalArgumentException();
		return this.getAmount().compareTo(o.getAmount());
	}
	
	@Override
	public Bill clone(){
		Bill b;
		try{
		b = (Bill) super.clone();
		b.dueDate = (Date) dueDate.clone();
		b.paidDate = (Date) paidDate.clone();
		b.amount = (Money) amount.clone();
		return b;
		}catch(CloneNotSupportedException e){
		e.printStackTrace();
		throw new RuntimeException();
		}
	}
}