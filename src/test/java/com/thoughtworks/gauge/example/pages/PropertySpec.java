package com.thoughtworks.gauge.example.pages;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;

public class PropertySpec {

    @Step("verify property")
    public void verifyProperty() {
        Assert.assertEquals("http://testurl", System.getenv("TEST_URL"));
    }

}
