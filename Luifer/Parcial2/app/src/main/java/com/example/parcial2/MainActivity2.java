package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.parcial2.adaptadores.UsuarioAdaptador;
import com.example.parcial2.clases.Libro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements UsuarioAdaptador.OnItemClickListener{

    public static final String dataUser = "dataUser";
    private static final int modoPrivate = Context.MODE_PRIVATE;
    TextView txt_usuario;
    String dato;
    RecyclerView rcv_libros;
    List<Libro> libroList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt_usuario = findViewById(R.id.txt_usuario);
        dato = getApplicationContext().getSharedPreferences(dataUser, modoPrivate).getString("user", "0");
        if (!dato.equals("0"))
            txt_usuario.setText(dato);
        else
            txt_usuario.setText("No hay información");

        rcv_libros = findViewById(R.id.rcv_libros);

        Libro lib1 = new Libro("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.oxigeno.com.pe%2Fcine-y-tv%2Fpiratas-del-caribe-asi-lucen-los-actores-de-esta-pelicula-actualmente-eg-noticia-1371001&psig=AOvVaw33pvE0me5DEukUT9AzTLp_&ust=1714865245927000&source=images&cd=vfe&opi=89978449&ved=0CBAQjRxqFwoTCIDIo4DR8oUDFQAAAAAdAAAAABAE", "piratas del caribe","Johnny Depp");
        Libro lib2 = new Libro("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.fotogramas.es%2Fnoticias-cine%2Fg18910299%2Fpiratas-del-caribe-perla-negra-interpretes%2F&psig=AOvVaw33pvE0me5DEukUT9AzTLp_&ust=1714865245927000&source=images&cd=vfe&opi=89978449&ved=0CBAQjRxqFwoTCIDIo4DR8oUDFQAAAAAdAAAAABAJ", "piratas del caribe", "Geoffrey Rush");
        Libro lib3 = new Libro("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.oxigeno.com.pe%2Fcine-y-tv%2Fpiratas-del-caribe-asi-lucen-los-actores-de-esta-pelicula-actualmente-eg-noticia-1371001&psig=AOvVaw33pvE0me5DEukUT9AzTLp_&ust=1714865245927000&source=images&cd=vfe&opi=89978449&ved=0CBAQjRxqFwoTCIDIo4DR8oUDFQAAAAAdAAAAABAR", "piratas del caribe", "Orlando Bloom");
        Libro lib4 = new Libro("https://www.google.com/search?sa=X&sca_esv=f6308176a63567fc&sca_upv=1&biw=1536&bih=730&q=Mackenzie+Crook&stick=H4sIAAAAAAAAAONgFuLSz9U3MDLPMi4rUeIEsU2SLHJMtCSzk6300zJzcsFEfHFqUWZqsVVyYnHJIlZ-38Tk7NS8qsxUBeei_PxsAMgjOs1GAAAA&ved=2ahUKEwjjxZPz0PKFAxXGRjABHR4YBg8Q9OUBegQIFRAO", "piratas del caribe", "Mackenzie Crook");

        libroList.add(lib1);
        libroList.add(lib2);
        libroList.add(lib3);
        libroList.add(lib4);

        rcv_libros.setLayoutManager(new LinearLayoutManager(this));
        rcv_libros.setAdapter(new UsuarioAdaptador(libroList));

        UsuarioAdaptador adaptador = new UsuarioAdaptador(libroList);
        rcv_libros.setAdapter(adaptador);
        adaptador.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(Libro libro) {
        Intent i = new Intent(MainActivity2.this, MainActivity3.class);
        i.putExtra("nombre", libro.getNombre());
        i.putExtra("imagen", libro.getImagen());
        i.putExtra("escritor", libro.getEscritor());
        startActivity(i);
        finish();
    }
}