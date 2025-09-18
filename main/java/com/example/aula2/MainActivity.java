package com.example.aula2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTitulo, editAutor;
    private CheckBox checkConcluido;
    private Button btnAdicionar;
    private ListView listLivros;

    private ArrayList<Livro> listaLivros;
    private ArrayAdapter<Livro> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTitulo = findViewById(R.id.editTitulo);
        editAutor = findViewById(R.id.editAutor);
        checkConcluido = findViewById(R.id.checkConcluido);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        listLivros = findViewById(R.id.listLivros);

        listaLivros = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaLivros);
        listLivros.setAdapter(adapter);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = editTitulo.getText().toString();
                String autor = editAutor.getText().toString();
                boolean concluido = checkConcluido.isChecked();

                if (titulo.isEmpty() || autor.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Todos os campos devem ser preenchidos", Toast.LENGTH_SHORT).show();
                } else {
                    Livro livro = new Livro(titulo, autor, concluido);
                    listaLivros.add(livro);
                    adapter.notifyDataSetChanged();

                    editTitulo.setText("");
                    editAutor.setText("");
                    checkConcluido.setChecked(false);
                    Toast.makeText(MainActivity.this, "Novo Livro Adicionado", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}