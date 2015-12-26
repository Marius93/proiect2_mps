import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ciprian on 12/3/2015.
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                bufferedImage.setRGB(i,j,(i << 16) | (j << 8) | (i+j));
            }
        }
        File file = new File("imagine.jpg");
        ImageIO.write(bufferedImage,"jpg",file);
    }
}
