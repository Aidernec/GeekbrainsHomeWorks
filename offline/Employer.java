package lesson04.offline;

public class Employer {
    private int id;
   private String name;
   private String position;
   private int wage;
   private int age;

    Employer(int id, String name, String position, int wage, int age){
        this.id = id;
        this.name = name;
        this.position = position;
        this.wage = wage;
        this.age = age;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }

    public int getWage(){
        return wage;
    }

    public int getAge(){
        return age;
    }

    public void setWage(int wage){
        this.wage = this.wage + wage;
    }

}
