package org.MobilePractice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IOSDriverManager {

    private static final ThreadLocal<IOSDriver> DRIVER = new ThreadLocal<>();
    private final String deviceId;


    public IOSDriverManager(String deviceId) {
        this.deviceId = deviceId;
    }

    public void createIOSDriver() throws MalformedURLException {
        final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/";
        DRIVER.set(new IOSDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilities()));
        setUpDriverTimeOuts();
    }

    public IOSDriver getIOSDriver() {
        return DRIVER.get();
    }

    private DesiredCapabilities getDesiredCapabilities() {
        final DesiredCapabilities capabilities = new DesiredCapabilities();

        try(FileInputStream fis = new FileInputStream("src/test/resources/iOSDevicesConfig.json")) {
            final var objectMapper = new ObjectMapper();
            final JsonNode jsonNode = objectMapper.readValue(fis, JsonNode.class);

            final var devices = jsonNode.get("iosDevices").elements();

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
                if (!commonProp.getKey().equals("iosDevices")) {
                    capabilities.setCapability(commonProp.getKey(),commonProp.getValue().asText());
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return capabilities;
    }

    private void setUpDriverTimeOuts() {
        getIOSDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void stopDriver() {
        getIOSDriver().quit();
    }


}
