package com.company;

import java.util.ArrayList;

//класс Поезд. Сохраняет в себе массив из Вагонов.

public class Train {
    private ArrayList<Wagon> wagones;

    public Train(ArrayList<Wagon> wagones){
        this.wagones = wagones;
    }

    public ArrayList<Wagon> getWagones(){
        return wagones;
    }

    //конструктор
    public Train(){
        wagones = new ArrayList<>();
    }

    //посчитать количество людей во всех вагонах
    public double getSumPeople(){
        double sum = 0;
        try {

            for (Wagon wg : wagones) {
                sum += wg.people;
            }
        }catch(NullPointerException e){
            System.out.println("Exception!");
        }
        finally {
            return sum;
        }
    }

    //посчитать количество багажных мест во всех вагонах
    public double getSumLuggage(){
        double lug = 0;
        try {
            for (Wagon wg : wagones) {
                lug += wg.luggage;
            }
        }catch (NullPointerException e){
            System.out.println("Exception!");
        } finally {
            return lug;
        }
    }

    //сортировать вагоны по комфортности
    public void sortByComfort(){
        try {
            for (int i = 0; i < wagones.size(); i++) {
                for (int j = 0; j < wagones.size(); j++) {
                    if (wagones.get(i).comfort < wagones.get(j).comfort) {
                        Wagon wg;
                        if (wagones.get(i).isSit()) {
                            wg = new WagonSit(wagones.get(i).number, wagones.get(i).comfort, wagones.get(i).people, wagones.get(i).luggage);
                        } else {
                            wg = new WagonSleep(wagones.get(i).number, wagones.get(i).comfort, wagones.get(i).people, wagones.get(i).luggage);

                        }

                        wagones.set(i, wagones.get(j));
                        wagones.set(j, wg);
                    }
                }
            }
        }
        catch(NullPointerException e){
            System.out.println("Depot is null!");
        }
    }

    //вывести вагоны для диапазона людей
    public ArrayList<Wagon> getWagonesByPeople(int quantityMin,int quantityMax){
        ArrayList<Wagon> res = new ArrayList<>();

        try {
            for (int i = 0; i < wagones.size(); i++) {
                if (wagones.get(i).people >= quantityMin && wagones.get(i).people <= quantityMax)
                    res.add(wagones.get(i));
            }
        }catch(NullPointerException e) {
            System.out.println("There are no wagones!");
        }
        return res;
    }

    //вывести вагоны
    public void print(){
        try {
            for (Wagon wg : wagones) {
                wg.print();
            }
        }
        catch(NullPointerException e){
            System.out.println("There are no wagones!");
        }
    }

    //добавить вагон
    public void addWagon(Wagon wagon){
        if (wagon == null)
            wagones = new ArrayList<>();
        wagones.add(wagon);
    }

}


