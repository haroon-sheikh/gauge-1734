package com.thoughtworks.gauge.example.pages;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.datastore.DataStoreFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class TestSpec {


    @Step("Set something <table>")
    public void setSomething(Table table) {
        table.getColumnNames().forEach(columnName -> {
                    String value = table.getTableRows().get(0).getCell(columnName);
                    if (value.equalsIgnoreCase("[null]")) {
                        return;
                    }
                    switch (columnName.toLowerCase()) {
                        case "key1":
                            DataStoreFactory.getScenarioDataStore().put("key1", value);
                            break;
                        case "key2":
                            DataStoreFactory.getScenarioDataStore().put("key2", value);
                            break;
                        case "key3":
                            DataStoreFactory.getScenarioDataStore().put("key3", value);
                            break;
                        default:
                            fail("Column name not recognised");
                            break;
                    }
                }
        );
    }

    @Step("Do something")
    public void doSomething() {
        System.out.println("Do something");
    }

    @Step("Do something <CONTEXT_URL>")
    public void implementation1(String url) {
        System.out.println(url);
    }

    @Step("Then should contain these headers <table>")
    public void shouldContian(Table table) {
        table.getTableRows().forEach((row -> {
            String headerName = row.getCell("key1");
            String headerValue = row.getCell("key2");
        }));
    }
}
