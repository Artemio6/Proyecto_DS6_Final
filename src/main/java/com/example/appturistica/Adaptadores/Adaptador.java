package com.example.appturistica.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.animation.content.Content;
import com.example.appturistica.*;
import com.example.appturistica.Clases.Noticia;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    Context context;
    ArrayList<Noticia> lista;

    public Adaptador(Context context, ArrayList<Noticia> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.noticias_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        holder.lbltitulo.setText(lista.get(position).getTitulo());
        holder.lblautor.setText(lista.get(position).getAutor());
        holder.lblmegusta.setText(String.valueOf(lista.get(position).getMe_gustas()));
        holder.imgImagen.setImageDrawable(lista.get(position).getImagen());
        holder.imgIcono.setImageDrawable(lista.get(position).getIcono());
        //Para el Lottie
        holder.ImgMegutas.setOnClickListener(new View.OnClickListener() {
            boolean megusta = false;
            @Override
            public void onClick(View v) {
                // Verifica el estado actual de me gusta
                if (!megusta) {
                    int cantidadMegusta = Integer.parseInt(holder.lblmegusta.getText().toString());
                    cantidadMegusta++;
                    holder.lblmegusta.setText(String.valueOf(cantidadMegusta));
                    holder.ImgMegutas.setRepeatCount(0);
                    holder.ImgMegutas.setSpeed(3f);
                    holder.ImgMegutas.playAnimation();
                    megusta = true;
                } else {
                    int cantidadMegusta = Integer.parseInt(holder.lblmegusta.getText().toString());
                    cantidadMegusta--;
                    holder.lblmegusta.setText(String.valueOf(cantidadMegusta));
                    holder.ImgMegutas.setSpeed(-4f);
                    holder.ImgMegutas.playAnimation();
                    megusta = false;
                }
            }
        });
        holder.imgImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el Drawable y convertirlo a Bitmap
                Drawable img = holder.imgImagen.getDrawable();
                Bitmap bitmapa = ((BitmapDrawable) img).getBitmap();

                // Crear un archivo temporal
                File cacheDir = context.getCacheDir();
                File tempFile = new File(cacheDir, "temp_image.png");
                try (FileOutputStream out = new FileOutputStream(tempFile)) {
                    bitmapa.compress(Bitmap.CompressFormat.PNG, 100, out);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(context, mostrar_informacion.class);
                intent.putExtra("titulo", lista.get(position).getTitulo());
                intent.putExtra("IMG_PATH", tempFile.getAbsolutePath());
                intent.putExtra("detalle",lista.get(position).getDetalle());
                intent.putExtra("latitud",lista.get(position).getLatitud());
                intent.putExtra("longitud",lista.get(position).getLongitud());
                context.startActivity(intent);
            }
        });
        holder.imgCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos del item en la posición dada
                String titulo = lista.get(position).getTitulo();
                String autor = lista.get(position).getAutor();
                String detalle = lista.get(position).getDetalle();

                // Crear el texto que se va a compartir
                String textoACompartir = "Título: " + titulo + "\n"
                        + "Autor: " + autor + "\n"
                        + "Detalle: " + detalle;

                // Crear un intent para compartir texto
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, textoACompartir);
                intent.setType("text/plain");
                // Iniciar el intent para compartir
                v.getContext().startActivity(Intent.createChooser(intent, "Compartir mediante"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView lbltitulo, lblautor, lblmegusta, lblDetalle;
        ImageView imgImagen, imgIcono, imgCompartir;
        LottieAnimationView ImgMegutas;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgImagen = itemView.findViewById(R.id.img_Imagen);
            lbltitulo = itemView.findViewById(R.id.lbl_titulo);
            imgIcono = itemView.findViewById(R.id.img_icono);
            lblautor = itemView.findViewById(R.id.lbl_autor);
            ImgMegutas = itemView.findViewById(R.id.like_img);
            lblmegusta = itemView.findViewById(R.id.lbl_megusta);
            imgCompartir = itemView.findViewById(R.id.compartir);

        }
    }
}
