package me.Zyrian.javalab4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import me.Zyrian.javalab4.Fillers.Filler;
import me.Zyrian.javalab4.Fillers.IFiller;
import me.Zyrian.javalab4.Tables.Table;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private ObservableList<Table> _tables = FXCollections.observableArrayList();

    private FileChooser _fileChooser = new FileChooser();

    private ToggleGroup _toggleGroup = new ToggleGroup();

    @FXML
    private TableView<Table> _tableView;

    @FXML
    private TableColumn<Table, Integer> _idColumn;

    @FXML
    private TableColumn<Table, String> _textColumn;

    @FXML
    private Label _selectedLabel;

    @FXML
    private Label _selectedRadioButtonsDisplayer;

    @FXML
    private RadioButton _oneRadioBtn;

    @FXML
    private RadioButton _twoRadioBtn;

    @FXML
    protected void onAddBtnClicked(){

        File file = _fileChooser.showOpenDialog(new Stage());
        IFiller filler = new Filler();
        filler.initialize(file);
        filler.fillContainer(_tables);

    }

    @FXML
    protected void onClearAllBtnClicked(){

        _tableView.getItems().clear();
    }

    @FXML
    protected void onClearSelectedBtnClicked(){

        ObservableList<Table> selectedRows = _tableView.getSelectionModel().getSelectedItems();
        ArrayList<Table> rows = new ArrayList<>(selectedRows);
        rows.forEach(row -> _tableView.getItems().remove(row));
    }

    @FXML
    protected void onOneBtnSelected(){

        _selectedRadioButtonsDisplayer.setText("One Button");
    }

    @FXML
    protected void onTwoBtnSelected(){

        _selectedRadioButtonsDisplayer.setText("Two Button");
    }

    private void tableDebug(){

        _tables.add(new Table(0, "Test"));
        _tables.add(new Table(1, "Test 2"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //tableDebug();  //Debug метод для проверки наличия контента в списке до момента добавления нового контента в список

        _idColumn.setCellValueFactory(new PropertyValueFactory<Table, Integer>("id"));
        _textColumn.setCellValueFactory(new PropertyValueFactory<Table, String>("text"));

        _tableView.setItems(_tables);
        _tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        _oneRadioBtn.setToggleGroup(_toggleGroup);
        _twoRadioBtn.setToggleGroup(_toggleGroup);

        _selectedRadioButtonsDisplayer.setText("None");
    }
}