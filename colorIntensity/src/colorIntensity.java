import com.diozero.ws281xj.LedDriverInterface;
import com.diozero.ws281xj.PixelAnimations;
import com.diozero.ws281xj.rpiws281x.WS281x;

public class colorIntensity {
    public static void main(String[] args) {
        int gpio_num = 10;
        int brightness = 225;  // 0..255
        int num_pixels = 60;

        System.out.println("Using GPIO " + gpio_num);

        try (LedDriverInterface led_driver = new WS281x(gpio_num, brightness, num_pixels)) {
            colorIntensityAnimation(led_driver);
        } catch (Throwable t) {
            System.out.println("Error: " + t);
            t.printStackTrace();
        }
    }

    private static void colorIntensityAnimation(LedDriverInterface ledDriver) {
        System.out.println("Color Intensity Animation");

        int delay = 20;
        int maxIntensity = 255;

        // Gradually increase and decrease color intensity
        for (int intensity = 0; intensity <= maxIntensity; intensity++) {
            for (int pixel = 0; pixel < ledDriver.getNumPixels(); pixel++) {
                ledDriver.setPixelColour(intensity, 0);
            }

            ledDriver.render();
            PixelAnimations.delay(delay);
        }

        for (int intensity = maxIntensity; intensity >= 0; intensity--) {
            for (int pixel = 0; pixel < ledDriver.getNumPixels(); pixel++) {
                ledDriver.setPixelColour(intensity, 0);
            }

            ledDriver.render();
            PixelAnimations.delay(delay);
        }
    }
}
