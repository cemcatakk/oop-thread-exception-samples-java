public class CustomDate implements Comparable {
    private int day;
    private int month;
    private int year;

    public CustomDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    @Override
    public String toString()
    {
        return day+"/"+month+"/"+year;
    }
    public CustomDate(CustomDate o){
        this.day=o.getDay();
        this.month=o.getMonth();
        this.year=o.getYear();
    }
    public void addDays(int days){
        if (getDay()==30){
            addMonths(1);
            setDay(1);
        }
        else{
            day++;
        }
    }
    public void addMonths(int months){
        if (getMonth()==12){
            addYears(1);
            setMonth(1);
        }
        else{
            month++;
        }
    }
    public void addYears(int years){
        year++;
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof CustomDate)){
            return -1;
        }
        else{
            if (getYear()>((CustomDate) o).getYear()){
                return 1;
            }
            else if(getYear()<((CustomDate) o).getYear()){
                return -1;
            }
            else{
                if(getMonth()>((CustomDate) o).getMonth()){
                    return 1;
                }
                else if(getMonth()<((CustomDate) o).getMonth()){
                    return -1;
                }
                else{
                    if(getDay()>((CustomDate) o).getDay()){
                        return 1;
                    }
                    else if(getDay()<((CustomDate) o).getDay()){
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            }
        }
    }
}
