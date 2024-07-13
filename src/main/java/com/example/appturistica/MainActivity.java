package com.example.appturistica;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.appturistica.Adaptadores.Adaptador;
import com.example.appturistica.Clases.Noticia;
import com.example.appturistica.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView RecycleNoticia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.vista_principal), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Agarra el ID de mi recycle para agregarla
        RecycleNoticia = findViewById(R.id.RecycleNoticia);
        ArrayList<Noticia> noticias = new ArrayList<>();

        //Se añade la infomacion al array noticia
        noticias.add(new Noticia(
                "Canal de Panama",
                "Autor 1",
                0,
                "En las Esclusas de Miraflores está el centro de visitantes. El centro incluye un museo, el cual muestra exhibiciones sobre la historia, héroes, todo el ecosistema del canal y una cinta sobre su creación.\n\nEn las afueras del centro, los turistas van a poder relajarse, o ver de forma cercana los barcos que circulan por las esclusas de Miraflores. Por igual, tienen la posibilidad de almorzar en el Restaurante de Miraflores, aprovechando la fantástica vista del canal.",
                getDrawable(R.drawable.canal_panama),
                getDrawable(R.drawable.icon_users),
                8.9966, -79.5905 // Coordenadas del Canal de Panamá
        ));

        noticias.add(new Noticia(
                "Casco Antiguo",
                "Autor 2",
                0,
                "La Localidad de Panamá, cuenta con un lugar histórico donde los techos de teja naranja y el diseño colonial español de la vieja ciudad de Panamá diferencian con los edificios de la bahía.",
                getDrawable(R.drawable.casco_antiguo),
                getDrawable(R.drawable.icon_users),
                8.9525, -79.5356 // Coordenadas del Casco Antiguo
        ));

        noticias.add(new Noticia(
                "Bocas del Toro",
                "Autor 3",
                0,
                "Localizado en la ribera noroeste del Caribe, este piélago tropical de 9 islas ha mantenido un profundo dominio de las Indias Occidentales. Con un ecoturismo y travesía, goce de varias de las superiores clases de buceo y surf en la zona.",
                getDrawable(R.drawable.bocas_del_toro_panama),
                getDrawable(R.drawable.icon_users),
                9.3333, -82.2500 // Coordenadas de Bocas del Toro
        ));

        noticias.add(new Noticia(
                "Boquete",
                "Autor 4",
                0,
                "Localizado en las montañas que se desarrollan hacia la vecina Costa Rica, el precioso Valle de las Flores, llamado también a Boquete, tiene muchas vivencias diferentes para prometerle.",
                getDrawable(R.drawable.boquete_panama),
                getDrawable(R.drawable.icon_users),
                8.7747, -82.4308 // Coordenadas de Boquete
        ));

        noticias.add(new Noticia(
                "Cerro Azul",
                "Autor 5",
                0,
                "Escondido entre enormes montañas, se ubica en uno de los famosos sitios turísticos de Panamá, muchos desean vivir en este parque natural por el clima fresco que brinda gracias a su ubicación y la tranquilidad que se puede percibir en él.\nHay una gran oferta en cabañas y hoteles que te permiten disfrutar de todo lo que te ofrece este paraíso natural, al igual que un hermoso mirador desde el cual puedes hacer kayak o, si prefieres, pesca en el lago.",
                getDrawable(R.drawable.cerro_azul),
                getDrawable(R.drawable.icon_users),
                9.1500, -79.4000 // Coordenadas de Cerro Azul
        ));

        noticias.add(new Noticia(
                "Isla Coiba",
                "Autor 6",
                0,
                "El arrecife de coral más enorme en el Pacífico tiene su hogar en el Parque Marino de Isla Coiba. Éste es considerado como uno de los mejores destinos turísticos en el planeta para hacer buceo y deleitarse la vista con las maravillas que da el fondo del océano.",
                getDrawable(R.drawable.isla_coiba),
                getDrawable(R.drawable.icon_users),
                7.5167, -81.7500 // Coordenadas de Isla Coiba
        ));

        noticias.add(new Noticia(
                "Portobelo",
                "Autor 7",
                0,
                "Conocida como la metrópoli pirata de Panamá, esta pequeña y encantadora urbe ubicada al norte del territorio, ha florecido a orillas del Caribe. Se puede recorrer a pie, y de esta forma encontrar los encantos que aguarda a cada paso; entre ellos, el Intenso de Santiago.",
                getDrawable(R.drawable.portobelo),
                getDrawable(R.drawable.icon_users),
                9.5549, -79.6543 // Coordenadas de Portobelo
        ));

        noticias.add(new Noticia(
                "Santa Catalina",
                "Autor 8",
                0,
                "Se ubica en una isla cerca a la ribera del Pacífico de Panamá, no dudes en visitarlo debido a que está llena de historias por ser una zona muy antigua.\n\nAsimismo, el poblado, por igual, es bastante notorio entre los surfistas que buscan apresar gigantes olas. Es una puerta de ingreso para el acceso del Parque Nacional Marino de Coiba.",
                getDrawable(R.drawable.santa_catalina),
                getDrawable(R.drawable.icon_users),
                7.6500, -81.2500 // Coordenadas de Santa Catalina
        ));

        noticias.add(new Noticia(
                "Valle de Anton",
                "Autor 9",
                0,
                "Es encontrada en el cráter de un volcán inactivo, con selvas tropicales que rebosan en los alrededores, además es ideal para transitar o montar en caballo.",
                getDrawable(R.drawable.valle_de_anton),
                getDrawable(R.drawable.icon_users),
                8.6000, -80.1333 // Coordenadas de Valle de Anton
        ));

        noticias.add(new Noticia(
                "Volcan Baru",
                "Autor 10",
                0,
                "El Volcán Barú sella el punto geográfico más preciado de Panamá, es uno de los destinos que tienes que visitar. Además, encontrarás aguas termales a pocos minutos de distancia, que son nutridas por las aguas termales que se encuentran debajo del volcán inactivo.",
                getDrawable(R.drawable.volcan_baru),
                getDrawable(R.drawable.icon_users),
                8.8086, -82.5410 // Coordenadas del Volcán Barú
        ));
        //Se declara un adaptador
        Adaptador adaptador = new Adaptador(this, noticias);
        RecycleNoticia.setLayoutManager(new LinearLayoutManager(this));
        //Se aSe agrega al el adaptador
        RecycleNoticia.setAdapter(adaptador);
    }
}
