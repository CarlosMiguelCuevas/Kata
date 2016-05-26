package solution;

import java.lang.reflect.Array;

/**
 * Created by carlos on 15/03/16.
 */
public class DisplayCase {
    private int[][] minum;
    private int[][] arraybinStatus; // array of ints binary that represent the status
    private final int LCDScreenLengrth = 12;
    private final int digitLength = 8;
    private int numLength = 0;

    public DisplayCase(int[][] bins, int[][] numero)
    {
        setArraybinStatus(bins);
        setNumLength(numero.length); //sub 1 because the '.' count as a character
        setNum(numero);
    }
    //region SETERS


    public void setArraybinStatus(int[][] arraybinStatus)
    {
        this.arraybinStatus = arraybinStatus;
    }

    public void setNumLength(int numLength) {
        this.numLength = numLength;
    }

    public void setNum(int[][] num) {
        this.minum = num;
    }
    //endregion

    public int test()
    {
        int valid = 1;
        int head = 0;
        //we test if the number can be displaied in the screen
        for(int i = 0; i<LCDScreenLengrth ;i++)
        {
            if(LCDScreenLengrth - i < minum.length - head )
            {
                //it doesm't fit any more
                valid = 0;
                break;

            }

            for (int j = 0; j<digitLength; j++)
            {
                if(minum[head][j] == 1 && arraybinStatus[i][j] != 1)
                {
                    valid = 0;
                    break;
                }
            }

            if(valid == 0)
            {

                head = 0;
                valid = 1;
            }
            else
            {
                head ++;
                if(head >= minum.length)
                {
                    break;
                }
            }

        }

        return valid;

    }



}
