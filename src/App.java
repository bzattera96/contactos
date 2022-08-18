import domain.Contacto;
import domain.Telefono;
import domain.enumTipoTel;
import service.Directorio;

import java.util.HashSet;
import java.util.Set;

public class App {
    public static final void main(String[] args) {
        //creando telefonos
        Telefono tel1 = new Telefono(enumTipoTel.MÓVIL, "+54", "01156561212");
        Telefono tel2 = new Telefono(enumTipoTel.MÓVIL, "+39", "016578456598");
        Telefono tel3 = new Telefono(enumTipoTel.MÓVIL, "+1", "3476966917");
        Telefono tel4 = new Telefono(enumTipoTel.MÓVIL, "+44", "212245778");

        //creando set de telefonos
        Set<Telefono> set1 = new HashSet<>();
        set1.add(tel3);
        set1.add(tel4);

        Set<Telefono> set2 = new HashSet<>();
        set2.add(tel2);
        set2.add(tel3);

        Set<Telefono> set3 = new HashSet<>();
        set3.add(tel1);

        Set<Telefono> set4 = new HashSet<>();
        set4.add(tel1);
        set4.add(tel2);
        set4.add(tel3);

        //creando contactos
        Contacto contacto1 = new Contacto("Brenda", "Zattera");
        Contacto contacto2 = new Contacto("Lucía", "Pérez");
        Contacto contacto3 = new Contacto("Juan", "Fernández", set3);
        Contacto contacto4 = new Contacto("Marcos", "González", set1);

        //creando directorio
        Directorio directorioBrenda = new Directorio();

        //llamando métodos
        directorioBrenda.registrarContacto(contacto1.getNombre(), contacto1.getApellido(), set2);
        directorioBrenda.registrarContacto(contacto3.getNombre(), contacto3.getApellido(), set3);
        directorioBrenda.registrarContacto(contacto2.getNombre(), contacto3.getApellido(), set1);
        directorioBrenda.registrarContacto(contacto4.getNombre(), contacto4.getApellido(), set1);


        System.out.println("----------------------");

        directorioBrenda.registrarTelefono("Pedro", "Sanchez", enumTipoTel.FIJO, "+39", "3461547765");
        directorioBrenda.registrarTelefono("Lucía", "Pérez", enumTipoTel.OFICINA, "+54", "2213659852");

        System.out.println("----------------------");

        directorioBrenda.removerContacto("Marcos", "González");
        directorioBrenda.removerContacto("Marcos", "De La Torre");

        System.out.println("----------------------");

        directorioBrenda.removerTelefono("Juan", "Fernández", "+54", "01156561212");
        directorioBrenda.removerTelefono("Juan", "Fernández", "+23", "123456789");

        System.out.println("----------------------");

        System.out.println(directorioBrenda.obtenerContacto());
    }
}