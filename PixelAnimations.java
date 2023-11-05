import com.diozero.ws281xj.LedDriverInterface;
import com.diozero.ws281xj.PixelColour;

public class PixelAnimations {
    public static void delay(int wait) {
        try { Thread.sleep(wait); }  catch (InterruptedException e) { }
    }

    public static void colourWipe(LedDriverInterface ledDriver, int colour, int wait) {
        for (int i=0; i<ledDriver.getNumPixels(); i++) {
            ledDriver.setPixelColour(i, colour);
            ledDriver.render();
            delay(wait);
        }
    }

    public static void rainbow(LedDriverInterface ledDriver, int wait) {
        for (int j=0; j<256; j++) {
            for (int i=0; i<ledDriver.getNumPixels(); i++) {
                ledDriver.setPixelColour(i, PixelColour.wheel((i+j) & 255));
            }
            ledDriver.render();
            delay(wait);
        }
    }

    /* Slightly different, this makes the rainbow equally distributed throughout */
    public static void rainbowCycle(LedDriverInterface ledDriver, int wait) {
        for (int j=0; j<256*5; j++) { // 5 cycles of all colors on wheel
            for (int i=0; i<ledDriver.getNumPixels(); i++) {
                ledDriver.setPixelColour(i, PixelColour.wheel(((i * 256 / ledDriver.getNumPixels()) + j) & 255));
            }
            ledDriver.render();
            delay(wait);
        }
    }

    /* Theatre-style crawling lights */
    public static void theatreChase(LedDriverInterface ledDriver, int c, int wait) {
        for (int j=0; j<10; j++) {  //do 10 cycles of chasing
            for (int q=0; q < 3; q++) {
                for (int i=0; i < ledDriver.getNumPixels(); i+=3) {
                    ledDriver.setPixelColour(i+q, c);    //turn every third pixel on
                }
                ledDriver.render();

                delay(wait);

                for (int i=0; i < ledDriver.getNumPixels(); i+=3) {
                    ledDriver.setPixelColour(i+q, 0);        //turn every third pixel off
                }
            }
        }
    }

    /* Theatre-style crawling lights with rainbow effect */
    public static void theatreChaseRainbow(LedDriverInterface ledDriver, int wait) {
        for (int j=0; j < 256; j++) {     // cycle all 256 colours in the wheel
            for (int q=0; q < 3; q++) {
                for (int i=0; i < ledDriver.getNumPixels(); i=i+3) {
                    ledDriver.setPixelColour(i+q, PixelColour.wheel( (i+j) % 255));    //turn every third pixel on
                }
                ledDriver.render();

                delay(wait);

                for (int i=0; i < ledDriver.getNumPixels(); i=i+3) {
                    ledDriver.setPixelColour(i+q, 0);        //turn every third pixel off
                }
            }
        }
    }

    public static void demo(LedDriverInterface ledDriver) {
        System.out.println("colourWipe - red");
        PixelAnimations.colourWipe(ledDriver, PixelColour.createColourRGB(255, 0, 0), 50); // Red
        System.out.println("colourWipe - green");
        PixelAnimations.colourWipe(ledDriver, PixelColour.createColourRGB(0, 255, 0), 50); // Green
        System.out.println("colourWipe - blue");
        PixelAnimations.colourWipe(ledDriver, PixelColour.createColourRGB(0, 0, 255), 50); // Blue
        //PixelAnimations.colourWipe(PixelColour.createColour(0, 0, 0, 255), 50); // White RGBW
        // Send a theatre pixel chase in...
        System.out.println("theatreChase - white");
        PixelAnimations.theatreChase(ledDriver, PixelColour.createColourRGB(127, 127, 127), 50); // White
        System.out.println("theatreChase - red");
        PixelAnimations.theatreChase(ledDriver, PixelColour.createColourRGB(127, 0, 0), 50); // Red
        System.out.println("theatreChase - blue");
        PixelAnimations.theatreChase(ledDriver, PixelColour.createColourRGB(0, 0, 127), 50); // Blue

        System.out.println("rainbow");
        PixelAnimations.rainbow(ledDriver, 20);
        System.out.println("rainbowCycle");
        PixelAnimations.rainbowCycle(ledDriver, 20);
    }
}