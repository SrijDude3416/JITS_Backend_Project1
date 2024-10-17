public class assignment {
    public String description;
    public double points; // max grade
    public String name;
    public Date duedate;
    public Date startdate;
    public String rubric;
    
    assignment(String description, double points, String name, Date duedate, Date startdate, String rubric){
        this.description=description;
        this.points=points;
        this.name=name;
        this.duedate=duedate;
        this.startdate=startdate;
        this.rubric=rubric;
    }

    // public HashMap<String>getParameters(){
    //     return
    // }

    class Date{
        String year;
        String month;
        String day;
        Date(String year, String month, String day){
            this.year=year;
            this.month=month;
            this.day=day;
        }

        public String getDate(){
            return year+" "+month+" "+day;
        }
    }

}
