package openCV;

import org.opencv.core.Mat;
import nu.pattern.OpenCV;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;

import static org.opencv.imgcodecs.Imgcodecs.CV_LOAD_IMAGE_COLOR;
import static org.opencv.imgproc.Imgproc.COLOR_RGB2GRAY;
import static org.opencv.imgproc.Imgproc.CV_HOUGH_GRADIENT;


public class CoinFinder {

    public static void main(String[] args) throws InterruptedException { //TODO: for debugging

        OpenCV.loadShared();

        String file = "src/main/resources/image1.jpg";
        Mat src = Imgcodecs.imread(file, CV_LOAD_IMAGE_COLOR);

        System.out.println(findCoins(src).toString());


    }

    public static ArrayList<Integer> findCoins(Mat mat) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<Integer>();

        //TODO: collapse code... only temporarily chunky for optimization

        Mat blur = new Mat();
        Mat edge = new Mat();
        Mat blur2 = new Mat();

        Imgproc.cvtColor(mat, mat, COLOR_RGB2GRAY);
        Imgcodecs.imwrite("gray.jpg", mat);

        Imgproc.blur(mat, blur, new Size(5,5));
        Imgcodecs.imwrite("blur.jpg", blur);

        int threshold = 10;

        Imgproc.Canny(blur, edge,threshold, threshold*3, 3, true);
        Imgcodecs.imwrite("edge.jpg", edge);

        Imgproc.GaussianBlur(edge, blur2, new Size(9, 9), 2, 2);
        Imgcodecs.imwrite("blur2.jpg", blur2);


        Mat circles = new Mat();


        //TODO: make minRadius more robust using , not a hardcoded value
        Imgproc.HoughCircles(blur2, circles, CV_HOUGH_GRADIENT, 1, blur2.rows() / 8,20, 100, 0, blur2.rows() / 10);

        System.out.println(blur2.rows());

        for (int x = 0; x < circles.cols(); x++) {
            double[] c = circles.get(0, x);
            Point center = new Point(Math.round(c[0]), Math.round(c[1]));
            // circle center
            Imgproc.circle(blur2, center, 1, new Scalar(0,100,100), 3, 8, 0 );
            // circle outline
            int radius = (int) Math.round(c[2]);
            Imgproc.circle(blur2, center, radius, new Scalar(255,0,255), 3, 8, 0 );
        }


        Imgcodecs.imwrite("blur2.jpg", blur2);

        return list;
    }

}
