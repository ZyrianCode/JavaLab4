package me.Zyrian.javalab4.Fillers;

import javafx.collections.ObservableList;
import me.Zyrian.javalab4.Tables.Table;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public interface IFiller {

    void fillContainer(ObservableList<Table> containerToFill);
    void initialize(@NotNull File file);
}
