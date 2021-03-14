package Utils;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public class FileUtils<T> {
    public List<T> read(File file, Class clazz)  {
        List<T> list = null;
       try(FileReader fileReader = new FileReader(file.getPath())){
           CsvToBean csvToBean = new CsvToBeanBuilder(fileReader)
                   .withType(clazz)
                   .withSeparator(',')
                   .build();
           list = csvToBean.parse();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return list;
    }

    public void write(File file,List<T> beans){
        try(Writer writer = new FileWriter(file.getPath())){
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();
            beanToCsv.write(beans);
        } catch (IOException
                | CsvRequiredFieldEmptyException
                | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }
}
