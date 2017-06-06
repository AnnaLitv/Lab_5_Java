package com.company;

//класс СпящийВагон наследник Вагона.

public class WagonSleep extends Wagon{
    public WagonSleep(){
        super();
    }

    public WagonSleep(int numbWag, int comfort, int people, int luggage){
        super(numbWag, comfort, people, luggage);
    }

    public boolean isSit() {
        return false;
    }//проверка на тип вагона
}
