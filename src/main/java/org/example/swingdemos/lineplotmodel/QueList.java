package org.example.swingdemos.lineplotmodel;

import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;

@ToString
public class QueList {

    LinkedList<Double> que = new LinkedList<>();
    private int maxLength;

    public QueList(int maxLength) {
        this.maxLength = maxLength;
    }

    public LinkedList<Double> getNumbersInQue () {
        return que;
    }

    public void pushNumber(double num) {
        que.add(num);
        if (que.size() > maxLength)
            que.removeFirst();
    }



}
