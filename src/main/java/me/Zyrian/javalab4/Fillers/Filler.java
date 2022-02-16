package me.Zyrian.javalab4.Fillers;

import javafx.collections.ObservableList;
import me.Zyrian.javalab4.Tables.Table;
import org.jetbrains.annotations.NotNull;

import java.io.*;

public class Filler implements IFiller {

    private File _file;
    private FileReader _fileReader;
    private BufferedReader _bufferReader;

    public void initialize(@NotNull File file)
    {
        try {

            _file = file;
            _fileReader = new FileReader(_file);
            _bufferReader = new BufferedReader(_fileReader);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void fillContainer(ObservableList<Table> containerToFill) {

        try {
            String line = _bufferReader.readLine();
            int id = checkContainerSize(containerToFill);

            while (line != null) {

                containerToFill.add(new Table(id, line));
                line = _bufferReader.readLine();
                id++;
            }

        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private int checkContainerSize(ObservableList<Table> containerToFill) {
        return containerToFill.size();
    }
}
