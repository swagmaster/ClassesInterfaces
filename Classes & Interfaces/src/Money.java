  
public class Money implements Comparable<Money>,Cloneable{

    //class variables
    private int dollars;
    private int cents;

    public Money(int dol){
        try{
            if(dol<0){
                throw new Exception("Dollars must be greater than 0.");
            }
            this.dollars = dol;

        }catch(Exception e){
            String message = e.getMessage();
            System.out.println(message);
        }
    }

    
    public Money(int dol, int cent){
        try{
            if(dol<0){
                throw new Exception("Dollars must be greater than 0.");
            }else if(cent<0){
                throw new Exception("Cents must be greater than 0");
            }
            setDollars(dol);
            if(cent>99){
                this.dollars += cent/100;
                this.cents = cent%100;
            }else{
                this.cents = cent;
            }
        }catch(Exception e){
            String message = e.getMessage();
            System.out.println(message);
        }

    }

    public Money(Money other){
        this.dollars = other.getDollars();
        this.cents = other.getCents();
    }

    public void setDollars(int dol){
        try{
            if(dol<0){
                throw new Exception("Dollars must be above 0");
            }
            this.dollars = dol;
        }catch(Exception e){
            String message = e.getMessage();
            System.out.println(message);
        }
    }

    public void setCents(int cent){
        try{
            if(cent<0){
                throw new Exception("Cents must be greater than 0");
            }
            if(cent>99){
                this.dollars += cent/100;
                this.cents = cent%100;
            }else{
                this.cents = cent;
            }
        }catch(Exception e){
            String message = e.getMessage();
            System.out.println(message);
        }
    }

    public int getDollars(){
        return dollars;
    }

    public int getCents(){
        return cents;
    }

    public double getMoney(){
        double money = dollars;
        double c = cents;
        c/=100;
        money += c;
        return money;
    }

    public void setMoney(int dol, int cent){
        try{
            if(dol<0){
                throw new Exception("Dollars must be greater than 0.");
            }else if(cent<0){
                throw new Exception("Cents must be greater than 0");
            }
            this.setDollars(dol);
            this.setCents(cent);
            if(cent>99){
                this.setDollars(dol + cent/100);
                this.setCents(cent%100);
            }else{
                this.cents = cent;
            }
        }catch(Exception e){
            String message = e.getMessage();
            System.out.println(message);
        }
    }

    public void add(int dol){
        try {
            if (dol < 0 && (dol * -1) > this.getDollars()) {
                throw new Exception("Amount too low, can't subtract");
            }
            this.dollars += dol;
        }catch(Exception e){
            String message = e.getMessage();
            System.out.println(message);
        }
    }

    public void add(int dol, int cent){
        try{
            if(dol<0 && cent>0 || dol>0 && cent<0){
                throw new Exception("Dollars and Cents must be both negative " +
                        "or both positive");
            }
            Money temp = new Money(this);
            this.dollars += dol;
            this.cents += cent;
            if(cent>99){//converts cents to dollars if cents exceeds 99
                this.dollars += cent/100;
                this.cents = cent%100;
            }//TODO: subtract cents
        }catch (Exception e){
            String message = e.getMessage();
            System.out.println(message);
        }
    }
    public void add(Money money){
        add(money.dollars, getCents());
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getClass() != obj.getClass()){
            return false;
        }
        Money that = (Money) obj;
        if(this.getDollars() == that.getDollars() &&
                this.getCents() == that.getCents()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        String money = "";
        if(cents<10){
            money += "$" + this.getDollars() + ".0" + this.getCents();
        }else {
            money += "$" + this.getDollars() + "." + this.getCents();
        }
        return money;
    }

    @Override
    public int compareTo(Money o) {
        if (getClass() != o.getClass()) {
            throw new IllegalArgumentException();
        }
        return Double.compare(o.getMoney(), getMoney());
    }

    @Override
    public Money clone(){
        Money m;
        try{
            m = (Money) super.clone();
            return m;
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
