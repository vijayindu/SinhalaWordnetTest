/**
 * Created by Vijayindu Gamage on 9/12/2014.
 */

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.dictionary.Dictionary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;


public class Main {

    public static void main(String arg[]) throws FileNotFoundException, JWNLException, UnsupportedEncodingException {

        FileInputStream inputStream = new FileInputStream("D:\\FYP\\Code\\WordNet\\Sinhala-WordNet-API-master\\SinhalaWordNetAPI\\src\\extjwnl\\src\\main\\resources\\net\\sf\\extjwnl\\file_properties.xml");
        Dictionary dic = Dictionary.getInstance(inputStream);


        ///convert utf word to iso so the getIndexWord will work
        byte ptext_[] = "අනතුර".getBytes("UTF-8");
        String value1 = new String(ptext_, "ISO-8859-1");


        IndexWord sinhala_word = dic.getIndexWord(POS.NOUN, value1);
        IndexWord english_word = dic.getIndexWord(POS.NOUN, "ace");

        //convert the output sinhala_word so it will correctly display in console
        byte ptext1[] = sinhala_word.toString().getBytes("ISO-8859-1");
        String value3 = new String(ptext1, "UTF-8");


        //print the English and sinhala words
        System.out.println("Sinhala word : " + value3);
        System.out.println("English word : " + english_word);

        Iterator<IndexWord> itr = dic.getIndexWordIterator(POS.NOUN);
        while (itr.hasNext()) {
            String output_word = itr.next().getLemma();
            //convert iso word to utf
            byte ptext[] = output_word.toString().getBytes("ISO-8859-1");
            String value = new String(ptext, "UTF-8");
            System.out.println(value);
        }


    }


}


