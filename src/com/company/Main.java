package com.company;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void initWagones(ArrayList<Wagon> wagones) {
        wagones.add(new WagonSleep(1, 1, 20, 20));
        wagones.add(new WagonSleep(2, 1, 20, 20));
        wagones.add(new WagonSleep(3, 2, 40, 20));
        wagones.add(new WagonSleep(4, 2, 40, 20));
        wagones.add(new WagonSit(5, 5, 68, 34));
        wagones.add(new WagonSit(6, 6, 112, 46));
        wagones.add(new WagonSit(7, 7, 81, 27));
        wagones.add(new WagonSleep(8, 3, 54, 27));
        wagones.add(new WagonSleep(9, 1, 20, 20));
        wagones.add(new WagonSleep(10, 2, 40, 20));
        wagones.add(new WagonSleep(11, 3, 54, 27));
        wagones.add(new WagonSleep(12, 1, 20, 20));
        wagones.add(new WagonSit(13, 4, 42, 14));
        wagones.add(new WagonSit(14, 6, 112, 46));
        wagones.add(new WagonSit(15, 4, 42, 14));
        wagones.add(new WagonSit(16, 5, 68, 34));
        wagones.add(new WagonSit(17, 5, 68, 34));
    }

    public static void separator(){
        System.out.println("**********************************************");
    }

    public static void printWagones(ArrayList<Wagon> wagones){
        System.out.println("Wagones in the depot: ");
        separator();
        for(int i = 0; i < wagones.size(); i++){
            wagones.get(i).print();
        }
        separator();
    }

    public static void menu(){
        System.out.println("*************Train constcructor************");
        System.out.println("1) Print wagones in depot");
        System.out.println("2) Add wagone to train");
        System.out.println("3) Add wagone to depot");
        System.out.println("4) Print wagones in train");
        System.out.println("5) Sort wagones in train by comfort");
        System.out.println("6) Get sum of people");
        System.out.println("7) Get sum of luggage");
        System.out.println("8) Find wagon in the train in the range of people");
        System.out.println("9) Exit");
        System.out.println("*******************************************");
    }

    public static Wagon findWagon(ArrayList<Wagon> wagones, int numb){

        for (Wagon wg: wagones){
            if (wg.number==numb)
                return wg;
        }
        return null;
    }

    public static void main(String[] args){

        ArrayList<Wagon> wagones = new ArrayList<>();
        initWagones(wagones);

        Train train = new Train();

        Scanner scanner = new Scanner(System.in);

        menu();
        System.out.println("Enter the number: ");

        int c = scanner.nextInt();

        while(c != 9){
            switch(c){
                case 1://печать вагонов в депо
                {
                    printWagones(wagones);
                    break;}
                case 2://добавить вагон из депо в поезд
                {
                    printWagones(wagones);
                    System.out.print("Enter the number of wagon: ");
                    int numb = scanner.nextInt();
                    Wagon res = findWagon(wagones, numb);
                    train.addWagon(res);
                }
                break;
                case 3://добавить вагон в депо
                {
                    System.out.print("Enter 0 if the wagon is sitting or other num if it is sleeping: ");
                    int type = scanner.nextInt();
                    Wagon newWagon;
                    try{
                        if(type>=0) {
                            if (type == 0)
                                newWagon = new WagonSit();
                            else
                                newWagon = new WagonSleep();
                        }else throw new NegativeValueException("type");
                        System.out.print("Enter number of wagon: ");

                        newWagon.number = scanner.nextInt();
                        if(newWagon.number<0) throw new NegativeValueException("Number ");

                        System.out.println("Enter the number of comfortable ");
                        if(type==0){ System.out.println("4-'Sidachiy 1 klass', 5-'Sidachiy 2 klass' ");
                            System.out.print("6-'Sidachiy 3 klass', 7-'Obschiy': ");}
                        else {
                            System.out.println("1-'SW', 2-'Kupe', 3-'Platskart': ");
                        }

                        newWagon.comfort = scanner.nextInt();
                        if(newWagon.comfort<0) throw new NegativeValueException("Comfort");

                        System.out.print("Enter the number of people: ");
                        newWagon.people = scanner.nextInt();
                        if(newWagon.people<0) throw new NegativeValueException("People");

                        System.out.print("Enter the number of luggage: ");
                        newWagon.luggage = scanner.nextInt();
                        if(newWagon.luggage<0) throw new NegativeValueException("Luggage");

                        wagones.add(newWagon);}
                    catch (NegativeValueException e){
                        System.out.println("Negative value!");
                    }
                    break;
                }
                case 4://печать поезда
                    train.print();
                    break;
                case 5://сортировать вагоны поезда по комфортности
                    train.sortByComfort();
                    train.print();
                    break;
                case 6://сумма людей в поезде
                    double SumPeople = train.getSumPeople();
                    System.out.println("Sum of people: " + SumPeople);
                    break;
                case 7://сумма багажа в поезде
                    double SumLuggage = train.getSumLuggage();
                    System.out.println("Sum of luggage: " + SumLuggage);
                    break;
                case 8://вагоны, которые вмещают количество людей из диапазона
                {
                    ArrayList<Wagon> results ;

                    System.out.print("Enter min quantity: ");
                    int quantityMin = scanner.nextInt();

                    System.out.print("Enter max quantity: ");
                    int quantityMax = scanner.nextInt();

                    results = train.getWagonesByPeople(quantityMin, quantityMax);

                    if (results.size() > 0) {
                        System.out.println("  ");
                        System.out.println("Proper wagones");
                        printWagones(results);
                    }
                    else {
                        System.out.println(" ");
                        System.out.println("No proper wagones!");
                    }
                    break;
                }

                default:
                    System.out.println("There is no such an option in menu!");
                    break;
            }

            menu();
            System.out.print("Enter your choice: ");

            try {
                c = scanner.nextInt();
            } catch(InputMismatchException e){
                System.out.println("Enter choice properly!");
            }
            scanner.nextLine();
        }
    }
}

