package com.thoughtworks.gauge.example.pages;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;

public class TestSpec {

    @Step("Some step that takes <seconds> seconds")
    public void someStepThatTakesNSeconds(int seconds) throws InterruptedException {
        System.out.println("Step running: " + seconds);
        Thread.sleep(seconds * 100);
    }

    @Step("Do something with a table <table>")
    public void doSomethingWithATable(final Table table) {
        System.out.println("Table: " + table);
    }

    @Step("Do something with another table <table>")
    public void doSomethingWithAnotherTable(final Table table) {
        System.out.println("Another table: " + table);
    }

}
