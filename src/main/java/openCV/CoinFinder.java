package openCV;

import org.opencv.core.Mat;
import nu.pattern.OpenCV;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.opencv.imgcodecs.Imgcodecs.CV_LOAD_IMAGE_COLOR;
import static org.opencv.imgproc.Imgproc.COLOR_RGB2GRAY;
import static org.opencv.core.CvType.CV_8U;


public class CoinFinder {

    public static void main(String[] args) throws InterruptedException { //TODO: for debugging

        OpenCV.loadShared();

        String file = "src/main/resources/image2.jpg";
        Mat src = Imgcodecs.imread(file, CV_LOAD_IMAGE_COLOR);

        System.out.println(findCoins(src).toString());


    }

    public static ArrayList<Integer> findCoins(Mat mat) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<Integer>();

        Mat gray = new Mat();
        Imgproc.cvtColor(mat, gray, COLOR_RGB2GRAY);
        Imgcodecs.imwrite("gray.jpg", gray);

        Mat edge = new Mat();
        Imgproc.Canny(gray, edge,50, 150, 3, true);
//        Imgproc.cvtColor(gray, edge, CV_8U);
        Imgcodecs.imwrite("edge.jpg", edge);

//        Mat draw = new Mat();
//        edge.convertTo(draw, CV_8U);
//        Imgcodecs.imwrite("draw.jpg", draw);

        

//        TimeUnit.SECONDS.sleep(1);


        return list;

    }

}
