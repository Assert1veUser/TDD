package program;

import program.Valute;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ValuteLoader {
    public List<Valute> loadValute(String fileName) throws IOException {
        if(fileName == null){
            return new ArrayList<>();
        }
        File file = new File(fileName);
        Valute valute;
        List<Valute> valuteList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            boolean isHeader = true;
            String readedLine = reader.readLine();
            while(readedLine != null){
                if(isHeader){
                    readedLine = reader.readLine(); //id,value
                    isHeader = false;
                    continue;
                }
                String[] readedLineSplitted = readedLine.split(",");
                valute = parseValute(readedLineSplitted);
                valuteList.add(valute);
                readedLine = reader.readLine();
            }
        }catch (IOException e) {
            throw e;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return valuteList;
    }

    private static Valute parseValute(String[] readedLineSplitted) throws ParseException {
        Valute valute;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        valute = new Valute(
                readedLineSplitted[0],
                Double.parseDouble(readedLineSplitted[1]),
                Integer.parseInt(readedLineSplitted[2]),
                readedLineSplitted[3],
                readedLineSplitted[4],
                formatter.parse(readedLineSplitted[5])
        );
        return valute;
    }
}
