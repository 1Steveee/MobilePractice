package org.MobilePractice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static java.time.Duration.*;

public class AndroidDriverManager {

    private AppiumDriver appiumDriver;
    private final String deviceId;

    public AndroidDriverManager(String deviceId) {
        this.deviceId = deviceId;
    }

    private DesiredCapabilities getDesiredCapabilities() {
        final DesiredCapabilities capabilities = new DesiredCapabilities();

        try (FileInputStream fis = new FileInputStream("src/test/resources/androidDevicesConfig.json")) {
            final var objectMapper = new ObjectMapper();
            final JsonNode jsonNode = objectMapper.readValue(fis, JsonNode.class);

            final var devices = jsonNode.get("androidDevices").elements();

            devices.forEachRemaining(device -> {
                if (device.get("id").asText().equals(deviceId)) {
                    final var deviceProperties = device.fields();

                    deviceProperties.forEachRemaining(property -> {
                        if (!property.getKey().equals("id")) {
                            capabilities.setCapability(property.getKey(), property.getValue().asText());
                        }
                    });
                }
            });

            final var commonProperties = jsonNode.fields();

            commonProperties.forEachRemaining(commonProp -> {
                if (!commonProp.getKey().equals("androidDevices")) {
                    capabilities.setCapability(commonProp.getKey(),commonProp.getValue().asText());
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return capabilities;
    }

    public void createAndroidDriver () throws MalformedURLException {
        appiumDriver = new AppiumDriver (new URL("http://localhost:4723/"), getDesiredCapabilities());
        setupDriverTimeouts();
    }



    public void stopDriver() {
        appiumDriver.quit();
    }

    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    private void setupDriverTimeouts () {
        appiumDriver.manage ()
                .timeouts ()
                .implicitlyWait (ofSeconds (30));
    }
}
