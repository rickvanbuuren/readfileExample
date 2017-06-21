import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static final String root = System.getProperty("user.dir");  //This line locates the root folder of your project
    private static final String FILENAME = root + "\\een_map_in_het_project\\Dikkeboktor.txt";  //This line specifies the file location within the root

    public static void main(String[] args) {

        List<String> mytextlist = getFileIndex(); //Create a new list of strings

        String[] mytext = new String[mytextlist.size()]; //Get the size of mytextlist
        mytext = mytextlist.toArray(mytext); //converts the list to an array

        StringBuilder strBuilder = new StringBuilder(); //create a new stringbuilder
        for (int i = 0; i < mytext.length; i++) {
            strBuilder.append(mytext[i]);
        }
        String newString = strBuilder.toString();

        String[] myData = newString.split("(=)|(;)");

        int boktor = Integer.parseInt(myData[1]);
        String flikkertje = myData[3];

        System.out.println("boktor " + Integer.toString(boktor));
        System.out.println("Joost is een " + flikkertje);
    }

    public static List<String> getFileIndex(){
        BufferedReader br = null;
        FileReader fr = null;

        List<String> fileIndex = new ArrayList<String>();

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String sCurrentLine;
            int count = 0;

            while ((sCurrentLine = br.readLine()) != null) {
                fileIndex.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return fileIndex;
    }
}