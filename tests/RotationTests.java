import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class RotationTests {
    @Test
    public void JahreszeitenTest() throws IOException {
        CompareTwoDotFiles("Jahreszeiten");
    }
    @Test
    public void LeftRightRotTest01() throws IOException {
        CompareTwoDotFiles("LeftRightRotTest01");
    }
    @Test
    public void LeftRotTest01() throws IOException {
        CompareTwoDotFiles("LeftRotTest01");
    }
    @Test
    public void LeftRotTest02() throws IOException {
       CompareTwoDotFiles("LeftRotTest02");
    }
    @Test
    public void RightLeftRotTest01() throws IOException {
        CompareTwoDotFiles("RightLeftRotTest01");
    }
    @Test
    public void RightRotTest01() throws IOException {
       CompareTwoDotFiles("RightRotTest01");
    }
    @Test
    public void RightRotTest02() throws IOException {
        CompareTwoDotFiles("RightRotTest02");
    }

    private void CompareTwoDotFiles(String fileName) throws IOException {
        File loesung = new File("tests/"+fileName+".dot");
        File erzeugt = new File("DotFiles/"+fileName+".dot");
        // soll
        BufferedReader br = new BufferedReader(new FileReader(loesung));
        String temp;
        StringBuilder soll = new StringBuilder();
        while ((temp = br.readLine()) != null) {
            soll.append(temp);
        }
        // ist
        br = new BufferedReader(new FileReader(erzeugt));
        temp = null;
        StringBuilder ist = new StringBuilder();
        while ((temp = br.readLine()) != null) {
            ist.append(temp);
        }
        // assert
        assertEquals(soll.toString(), ist.toString());
    }
}
