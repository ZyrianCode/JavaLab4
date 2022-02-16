package me.Zyrian.javalab4.Tables;

public class Table {

    private int _id;
    private String _text;

    public Table(){

    }

    public Table(int id, String text){

        _id = id;
        _text = text;
    }

    public int getId(){
        return _id;
    }

    public String getText(){
        return _text;
    }

    public void setId(int Id){
        _id = Id;
    }

    public void setText(String Text){
        _text = Text;
    }
}
