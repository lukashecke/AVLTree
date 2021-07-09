import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class RotationTests {
    @Test
    public void JahreszeitenTest() throws IOException {
        File loesung = new File("tests/Jahreszeiten.dot");
        File erzeugt = new File("DotFiles/Jahreszeiten.dot");
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
    @Test
    public void LeftRightRotTest01() throws IOException {
        File loesung = new File("tests/LeftRightRotTest01.dot");
        File erzeugt = new File("DotFiles/LeftRightRotTest01.dot");
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
    @Test
    public void LeftRotTest01() throws IOException {
        File loesung = new File("tests/LeftRotTest01.dot");
        File erzeugt = new File("DotFiles/LeftRotTest01.dot");
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
    @Test
    public void LeftRotTest02() throws IOException {
        File loesung = new File("tests/LeftRotTest02.dot");
        File erzeugt = new File("DotFiles/LeftRotTest02.dot");
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
    @Test
    public void RightLeftRotTest01() throws IOException {
        File loesung = new File("tests/RightLeftRotTest01.dot");
        File erzeugt = new File("DotFiles/RightLeftRotTest01.dot");
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
    @Test
    public void RightRotTest01() throws IOException {
        File loesung = new File("tests/RightRotTest01.dot");
        File erzeugt = new File("DotFiles/RightRotTest01.dot");
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
    @Test
    public void RightRotTest02() throws IOException {
        File loesung = new File("tests/RightRotTest02.dot");
        File erzeugt = new File("DotFiles/RightRotTest02.dot");
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
