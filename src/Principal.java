import com.alura.screenmatch.calculos.CalculadoraDeTiempo;
import com.alura.screenmatch.calculos.FiltroRecomendacion;
import com.alura.screenmatch.modelos.Episodio;
import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class Principal
{
    public static void main(String[] args)
    {
        // screen mathc peliculas codigo
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionEnMinutos(180);
        System.out.println("Duración de la película: " + miPelicula.getDuracionEnMinutos());

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(8);
        miPelicula.evalua(5);
        miPelicula.evalua(10);
        System.out.println("Total de evaluaciones: " + miPelicula.getTotalDeEvaluaciones());
        System.out.println(miPelicula.calculaMediaEvaluaciones());


        Serie lost = new Serie("Lost", 2000);
        lost.muestraFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duracion de la série: " + lost.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
        otraPelicula.setDuracionEnMinutos(200);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluido(miPelicula);
        calculadora.incluido(otraPelicula);
        calculadora.incluido(lost);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtro = new FiltroRecomendacion();
        filtro.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizaciones(300);
        filtro.filtra(episodio);

        var peliculaDeBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaDeBruno.setDuracionEnMinutos(180);

        ArrayList<Titulo> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaDeBruno);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);
        listaDePeliculas.add(lost);

        listaDePeliculas.forEach(System.out::println);



        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        System.out.println("La primera pelicula es: " + listaDePeliculas.get(0).getNombre());
        System.out.println(listaDePeliculas.toString());
        System.out.println("toString de la pelicula: " + listaDePeliculas.get(0).toString());

        for (Titulo item: listaDePeliculas){
            System.out.println(item);
        }

       // ordenacion en una lista [Formas]

        List<String> listaDeNombres = new ArrayList<>();

        listaDeNombres.add("Jonatan romero");
        listaDeNombres.add("Stiven morelo");
        listaDeNombres.add("Goku Saya");

        System.out.println(listaDeNombres);

        Collections.sort(listaDeNombres);

        System.out.println("lista ordenada : " + listaDeNombres);

        // aqui voy a ordenar una lista de objetos con el compareTo que está siendo usado como polimorfismo
        // en la CLASE Titulo es decir nosotros lo implementamos para organizar los nombres de las peliculas
        // ya que estas instancias son objetos y como tal no pueden ser comparadas ya que el compareTo ,
        // organiza tipos de datos complejos o atomicos

        Collections.sort(listaDePeliculas);

        System.out.println("Nombre de las peliculas ordenadas : "+ listaDePeliculas);

        listaDePeliculas.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));

        System.out.println("lista ordenada segun la fecha : "+ listaDePeliculas);
    }
}
