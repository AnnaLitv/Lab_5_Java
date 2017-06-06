package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Anna-PC on 06.06.2017.
 */
import java.util.ArrayList;
public class TrainTest {
    @Test
    public void getSumPeople() throws Exception {
        Train train = new Train();
        train.addWagon(new WagonSleep(1, 1, 20, 20));
        train.addWagon(new WagonSleep(2, 1, 20, 20));
        train.addWagon(new WagonSleep(3, 2, 40, 20));
        train.addWagon(new WagonSleep(4, 2, 40, 20));
        train.addWagon(new WagonSit(5, 5, 68, 34));
        train.addWagon(new WagonSit(6, 6, 112, 46));
        double sum = 20+20+40+40+68+112;
        assertEquals(sum,train.getSumPeople(),0);
    }


    @Test
    public void getSumLuggage() throws Exception {
        Train train = new Train();
        train.addWagon(new WagonSleep(1, 1, 20, 20));
        train.addWagon(new WagonSleep(2, 1, 20, 20));
        train.addWagon(new WagonSleep(3, 2, 40, 20));
        train.addWagon(new WagonSleep(4, 2, 40, 20));
        train.addWagon(new WagonSit(5, 5, 68, 34));
        train.addWagon(new WagonSit(6, 6, 112, 46));
        double sum = 20+20+20+20+34+46;
        assertEquals(sum,train.getSumLuggage(),0);
    }


    @Test
    public void getWagonesByPeople() throws Exception {
        Train train = new Train();
        train.addWagon(new WagonSleep(1, 1, 20, 20));
        train.addWagon(new WagonSleep(2, 1, 20, 20));
        train.addWagon(new WagonSleep(3, 2, 40, 20));
        train.addWagon(new WagonSleep(4, 2, 40, 20));
        train.addWagon(new WagonSit(5, 5, 68, 34));
        train.addWagon(new WagonSit(6, 6, 112, 46));
        ArrayList<Wagon> res = new ArrayList<>();
        res = train.getWagonesByPeople(25, 70);
        int s = res.size();
        assertEquals(3, s);
    }


}