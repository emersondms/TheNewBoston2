package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SQLite extends Activity {

    EditText buckysInput;
    TextView buckysSQLiteText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite);

        buckysInput = (EditText) findViewById(R.id.buckysInput);
        buckysSQLiteText = (TextView) findViewById(R.id.buckysSQLiteText);
        dbHandler = new MyDBHandler(this, null, null, 1);

        printDatabase();
    }

    //Add a product to the database
    public void addButtonClicked(View view) {
        Products product = new Products(buckysInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete items
    public void deleteButtonClicked(View view) {
        String inputText = buckysInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    private void printDatabase() {
        String dbString = dbHandler.databaseToString();
        buckysSQLiteText.setText(dbString);
        buckysInput.setText("");
    }

}
