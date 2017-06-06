package com.company;

//абстрактный класс Вагон.

public abstract class Wagon {
    int comfort;
    int number;
    int people;
    int luggage;

    public Wagon() {
        comfort=0;
        number = 0;
        people = 0;
        luggage = 0;
    }

    public Wagon(int number,int comfort, int people, int luggage){

        try {
            if (number<0)
                throw new NegativeValueException("NumberWagon");
            this.number = number;
            if (comfort<0)
                throw new NegativeValueException("Comfort");
            this.comfort = comfort;
            if (people<0)
                throw new NegativeValueException("People");
            this.people = people;
            if (luggage<0)
                throw new NegativeValueException("Luggage");
            this.luggage = luggage;
        }catch(NegativeValueException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void print(){
        if (isSit()) {
            System.out.println("VagonSit: " + number);
        } else {
            System.out.println("VagonSleep: " + number);
        }
        System.out.println("Comfort: " + String.valueOf(comfort));
        System.out.println("People: " + String.valueOf(people));
        System.out.println("Luggage: " + String.valueOf(luggage));
        System.out.println("------------------------------------------");
    }//вывод вагона

    public abstract boolean isSit();//проверка на тип

}


