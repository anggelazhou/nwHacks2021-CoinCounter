package openCV;

import org.opencv.core.Mat;
import nu.pattern.OpenCV;
import org.opencv.imgcodecs.Imgcodecs;

import java.util.ArrayList;



public class CoinFinder {

    public static void main(String[] args){ //TODO: for debugging

        OpenCV.loadShared();

        String file = "src/main/resources/image2.jpg";
        Mat src = Imgcodecs.imread(file, 0);
        Mat dst = src;

    }

    public static ArrayList<Integer> findCoins(Mat mat){
        ArrayList<Integer> list = new ArrayList<Integer>();




        return list;

    }

}
