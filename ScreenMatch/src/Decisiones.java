public class Decisiones {
    public static void main(String[] args) {
        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double notaDeLaPelicula = 8.2f;
        String plan = "plus";

        if(fechaDeLanzamiento > 2022) {
            System.out.println("Peliculas más populares");
        }else{
            System.out.println("Peliculas retro que aún vale la pena ver");
        }

        if(incluidoEnElPlan || plan.equals("plus")){
            System.out.println("Disfrute de su pelicula");
        }else {
            System.out.println("Pelicula no disponible para su plan actual");
        }
    }
}
