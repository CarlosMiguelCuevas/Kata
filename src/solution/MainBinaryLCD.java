package solution;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by carlos on 15/03/16.
 */
public class MainBinaryLCD {
    public static void main(String[] args){
        String str;
        try {
            ReadFile rf = new ReadFile("input.txt");
            while((str = rf.getline()) != null)
            {
                PreporcesText pre = new PreporcesText(str);
                DisplayCase dis = new DisplayCase(pre.getStatus(), pre.getnum());
                ouput o = new Displaystdrd();
                o.display(dis.test());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex){

        }
    }
}
