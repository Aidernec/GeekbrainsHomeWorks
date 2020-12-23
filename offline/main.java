package lesson04.offline;

public class main {
    static int id = 0;
    public static void main(String[] args){
            Employer employer = new Employer(999,"Michael De Santa", "programmer", 2500, 25);

            // Задание 1-3
            System.out.println(employer.getName());
            System.out.println(employer.getPosition());


            // Задание 4-5
            Employer[] employersArray = new Employer[5];
            employersArray[0] = new Employer(setId(),"David", "desiner", 1500, 30);
            employersArray[1] = new Employer(setId(),"Stan", "project manager", 3300, 42);
            employersArray[2] = new Employer(setId(),"Gary", "tester", 1500, 45);
            employersArray[3] = new Employer(setId(),"Mary", "chief engineer", 3500, 38);
            employersArray[4] = new Employer(setId(),"Sara", "desiner", 1500, 40);
            for(Employer item : employersArray){
                if(item.getAge() > 40){
                    System.out.println(item.getId());
                    System.out.println(item.getName());
                    System.out.println(item.getPosition());
                    System.out.println(item.getWage());
                    System.out.println(item.getAge());
                }
            }

            // Задание 6
            for (Employer item : employersArray){
                if(item.getAge() > 35){
                    item.setWage(10000);
                    System.out.println(item.getName());
                    System.out.println(item.getWage());
                }
            }
        }
        //Задание 7
        public static int setId(){
            id++;
            return id;
        }
}
