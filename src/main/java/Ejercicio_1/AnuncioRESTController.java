package Ejercicio_1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AnuncioRESTController {
    private Map<Long, Anuncio> anuncios = new ConcurrentHashMap<>();
    private AtomicLong lastId = new AtomicLong();

    public AnuncioRESTController() {
        anuncios.put(lastId.incrementAndGet() ,new Anuncio("Pepe", "Hola caracola", "XXXX"));
        anuncios.put(lastId.incrementAndGet() ,new Anuncio("Juan", "Hola caracola", "XXXX"));
    }

    @PostMapping("/anuncios/")
    @ResponseStatus(HttpStatus.CREATED)
    public Anuncio nuevoAnuncio(@RequestBody Anuncio anuncio){
        long id = lastId.incrementAndGet();
        anuncio.setId(id);
        anuncios.put(id, anuncio);
        return anuncio;
    }

    /*
    @GetMapping("/anuncio")
    public Anuncio anuncio() {
        return new Anuncio ("Peeeepe","Vendo moto", "El otro día...");
    }
    */

    @GetMapping("/anuncios/{id}")
    public ResponseEntity<Anuncio> getAnuncio(@PathVariable long id) {
        Anuncio anuncio = anuncios.get(id);
        if (anuncio != null){
            return new ResponseEntity<>(anuncio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/anuncios/{id}")
    public ResponseEntity<Anuncio> borraAnuncio(@PathVariable long id){

        Anuncio anuncio = anuncios.remove(id);
        if(anuncio != null){
            return new ResponseEntity<>(anuncio, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/anuncios/{id}")
    public ResponseEntity<Anuncio> actualizaAnuncio(@PathVariable long id, @RequestBody Anuncio anuncioActualizado){
        Anuncio anuncio = anuncios.get(id);
        if (anuncio != null){
            anuncioActualizado.setId(id);
            anuncios.put(id, anuncioActualizado);
            return new ResponseEntity<>(anuncioActualizado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
