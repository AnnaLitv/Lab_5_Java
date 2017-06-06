package com.company;

//класс СидячийВагон наследник Вагона.

public class WagonSit extends Wagon  {
    public WagonSit(){
        super();
    }

    public WagonSit(int numbWag, int comfort, int people, int luggage) {super(numbWag, comfort, people, luggage);}

    public boolean isSit() {
        return true;
    }//проверка на тип
}
