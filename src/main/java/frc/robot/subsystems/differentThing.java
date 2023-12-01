package frc.robot.subsystems;

public class differentThing {
    public String person;
    public int age;
    public double blood;
    private double amountOfWarCrimesCommited;

    public differentThing (String nameOfPerson, int howOld, double amountOfBlood){
        person = nameOfPerson;
        age = howOld;
        blood = amountOfBlood;
        System.out.println(nameOfPerson + " " + howOld + " " + amountOfBlood);
    }
    public void increaseAge() {
        age = age + 1;
    }
}