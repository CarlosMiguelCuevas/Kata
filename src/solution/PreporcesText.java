package solution;

/**
 * Created by carlos on 15/03/16.
 */
public class PreporcesText {
    private String substatus;
    private String subNum;
    private String[] numeroTraduccion;
    private int lengthNumero;
    private final int numberbinaryLength = 8;
    private final int LCDLenght =12;

    public PreporcesText(String s){
        int indexsemicilon = s.indexOf(";");
        setSubstatus(s.substring(0,indexsemicilon));
        setSubNum(s.substring(indexsemicilon+1));
        setLengthNumero(subNum.length());
        setNumeroTraduccion(new numerosValidos2().getListan());

    }

    public int[][] getStatus(){
        int[][] array = new int[LCDLenght][numberbinaryLength];


        for (int i = 0; i < LCDLenght; i++ )
        {
            int space;
            String undersbs;
            String supsbs;

            space = substatus.indexOf(" ");
            if(space != -1)
            {
                undersbs = substatus.substring(0,space);
            }
            else
            {
                undersbs = substatus.substring(0);
            }

            supsbs = substatus.substring(substatus.indexOf(" ") + 1);
            setSubstatus(supsbs);

            for (int j = 0 ; j < numberbinaryLength; j++) {
                array[i][j] = Integer.parseInt(String.valueOf(undersbs.charAt(j)));
            }


        }

        return array;
    }

    public int[][] getnum(){
        boolean punto = false;
        int memory = 0;
        int [][] numberArray = new int[lengthNumero-1][numberbinaryLength];

        for (int i=0; i<lengthNumero; i++)
        {
            int numero;
            try
            {
                numero = Integer.parseInt(String.valueOf(subNum.charAt(i)));

            }
            catch(Exception ex)
            {
                memory = i-1;
                punto = true;
                continue;
            }

            String numS = numeroTraduccion[numero];

            for(int j = 0; j < numberbinaryLength; j++)
            {
                if(!punto)
                {
                    numberArray[i][j] = Integer.parseInt(String.valueOf(numS.charAt(j)));
                }
                else
                {
                    numberArray[i-1][j] = Integer.parseInt(String.valueOf(numS.charAt(j)));
                }



            }


        }
        numberArray[memory][numberbinaryLength-1] = 1;


        return numberArray;
    }

    //region SETTERS
    public void setNumeroTraduccion(String[] numeroTraduccion) {
        this.numeroTraduccion = numeroTraduccion;
    }

    public void setSubstatus(String substatus) {
        this.substatus = substatus;
    }

    public void setSubNum(String subNum) {
        this.subNum = subNum;
    }

    public void setLengthNumero(int lengthNumero) {
        this.lengthNumero = lengthNumero;
    }
    //endregion
}
