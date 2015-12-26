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

    private final static int WIDTH = 1000;
    private final static int HEIGHT = 1000;

    public static void main(String[] args) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                bufferedImage.setRGB(i,j,generateByPixel(i,j,(i+j)%7,i+j* 100));
            }
        }
        File file = new File("imagine.jpg");
        ImageIO.write(bufferedImage,"jpg",file);
    }

    static int generateByPixel(int x, int y, int mod, int diff){
        if(mod == 1){//cos
            return diff + (int)(Math.cos((double)x) + Math.cos((double)y));
        }
        if(mod == 2 ){
            return diff + Math.abs(x) + Math.abs(y);
        }
        if(mod == 3){
            return diff + (int)(Math.sqrt((double)x) + Math.sqrt((double)y));
        }
        if(mod == 4){
            return  diff + (int)(Math.tan((double) x) + Math.tan((double) y));
        }
        if(mod == 5){
            return diff + (int)Math.abs(Math.tan((double)x) * 1.02d * Math.sqrt((double)x) * 1.02d * Math.sqrt((double)y));
        }
        if(mod == 6){
            double x0 = -2.0d + (double)x / ((double)WIDTH * 0.37d);
            double y0 = -1.2d + (double)y / ((double)HEIGHT * 0.4d);
            double xx = 0.0d;
            double yy = 0.0d;
            long iteration = 0;
            long max_iteration = HEIGHT;
            while(iteration < max_iteration && xx *xx + yy * yy <= 4.d){
                double var22 = xx * xx - yy * yy + x0;
                yy = 2.0D * xx * yy + y0;
                xx = var22;
                iteration++;
            }
            if(iteration == max_iteration) {
                return  0;
            } else {
                return (int) (diff + iteration);
            }
        }
        if(mod == 0){
            double diff2 = -16777216;
            double x0 = -2.0d + (double)x / ((double)WIDTH * 0.37d);
            double y0 = -1.2d + (double)y / ((double)HEIGHT * 0.4d);
            double xx = 0.0d;
            double yy = 0.0d;
            long iteration = 0;
            long max_iteration = HEIGHT;
            while(iteration < max_iteration && xx *xx + yy * yy <= 4.d){
                double var22 = xx * xx - yy * yy + x0;
                yy = 2.0D * xx * yy + y0;
                xx = var22;
                iteration++;
            }
            if(iteration == max_iteration) {
                return  0;
            } else {
                return (int) (diff+ diff2 + iteration);
            }
        }
        return 0;
    }
}
