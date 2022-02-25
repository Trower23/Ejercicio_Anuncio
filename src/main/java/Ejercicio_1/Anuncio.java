package Ejercicio_1;


public class Anuncio {
    private long id = -1; //Inicializar en -1 para que empiece en 0
    private String nombre;
    private String asunto;
    private String comentario;

    public Anuncio() {

    }

    public Anuncio(String nombre, String asunto, String comentario) {
        super();
        this.nombre = nombre;
        this.asunto = asunto;
        this.comentario = comentario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Anuncio [nombre=" + nombre + ", asunto=" + asunto + ", comentario=" + comentario + "]";
    }

    public void setId(long id) {
    }
}