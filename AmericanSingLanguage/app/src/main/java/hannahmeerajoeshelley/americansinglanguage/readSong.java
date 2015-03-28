//package hannahmeerajoeshelley.americansinglanguage;
//
//import android.content.Context;
//import android.content.res.AssetManager;
//import android.util.Log;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
///**
// * Created by chenleishen on 15-03-28.
// */
//
//public class readSong {
//
//    public static void ReadSong() {
//        InputStream file;
//        int i;
//        char c;
//        try {
//            AssetManager assetManager = Context.getAssets();
//            FileInputStream fis = openFileInput("TwinkleTwinkle.txt", Context.MODE_PRIVATE);
//            InputStreamReader isr = new InputStreamReader(fis);
//            BufferedReader bufferedReader = new BufferedReader(isr);
//            StringBuilder sb = new StringBuilder();
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                sb.append(line);
//            }
//            //file = Context.assetManager.open("BlockForTest.txt");
//            //file = new FileInputStream("TwinkleTwinkle.txt");
////            while((i=file.read())!=-1) {
////                c =(char)i;
////                System.out.print(c);
////            }
//            Log.e("worked", "worked");
//            //fos.write(editText1.getText().toString().getBytes());
//            //fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
////        Scanner s = null;
////        s = new Scanner(new BufferedReader(new FileReader("TwinkleTwinkle.txt")));
////        s.useDelimiter('\n');
//    };
//
//}
