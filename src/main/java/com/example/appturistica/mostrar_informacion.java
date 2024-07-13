package com.example.appturistica;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class mostrar_informacion extends AppCompatActivity {
    TextView lbl_titulo_info, lbl_Detalle_info;
    ImageView img_info;

    ImageButton btn_ubicacion, btn_llamada, btn_compartir, btn_volver, btn_web, btn_tube;
    Double latitud, longitud;
    String Numero_telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mostrar_informacion);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layout_info), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //declaraciones de IDES
        lbl_titulo_info = findViewById(R.id.lbl_titulo_info);
        img_info = findViewById(R.id.img_Imagen_info);
        lbl_Detalle_info = findViewById(R.id.lbl_detalle2_info);

        btn_ubicacion = findViewById(R.id.button_ubicacion_info);
        btn_llamada = findViewById(R.id.button_llamada_info);
        btn_compartir = findViewById(R.id.button_compartir_info);
        btn_volver = findViewById(R.id.button_volver);
        btn_web = findViewById(R.id.buttonWeb_info);
        btn_tube = findViewById(R.id.buttonTube_info);

        // Recibir y mostrar el título y detalles
        lbl_titulo_info.setText(getIntent().getExtras().getString("titulo"));
        lbl_Detalle_info.setText(getIntent().getExtras().getString("detalle"));
        //latitud y longitud para usarlo en el boton de Ubicacion
        latitud = getIntent().getExtras().getDouble("latitud", 0.0);
        longitud = getIntent().getExtras().getDouble("longitud", 0.0);
        // recogemos los
        // Recibir y mostrar la imagen
        String imgPath = getIntent().getExtras().getString("IMG_PATH");
        if (imgPath != null) {
            //Conversion
            Bitmap conversion = BitmapFactory.decodeFile(imgPath);

            img_info.setImageBitmap(conversion);
        }

        //boton ubicacion
        btn_ubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitud, longitud);
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(uri)) ;
                startActivity(intent);
            }
        });
        btn_llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Numero_telefono = "+50766491507";
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + Numero_telefono));
                startActivity(intent);
            }
        });
        // Botón compartir
        btn_compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = lbl_titulo_info.getText().toString();
                String detalle = lbl_Detalle_info.getText().toString();

                // Crear el Intent para compartir texto e imagen
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, titulo);
                shareIntent.putExtra(Intent.EXTRA_TEXT, detalle);

                // Si hay imagen, agregarla al Intent como un stream
                if (img_info.getDrawable() instanceof BitmapDrawable) {
                    Bitmap bitmap = ((BitmapDrawable) img_info.getDrawable()).getBitmap();
                    String imgPath = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Imagen compartida", null);
                    Uri imgUri = Uri.parse(imgPath);
                    shareIntent.putExtra(Intent.EXTRA_STREAM, imgUri);
                    shareIntent.setType("image/*");
                }
                startActivity(Intent.createChooser(shareIntent, "Compartir"));
            }
        });
        // boton web
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String url = "https://explorandomaravillas.com/lugares-turisticos-de-panama/";
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        btn_tube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String Tube = "https://youtu.be/EOcFJLYgOr0";
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Tube));
                startActivity(intent);
            }
        });
        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mostrar_informacion.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
