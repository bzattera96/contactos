package service;

import domain.Contacto;
import domain.Telefono;
import domain.enumTipoTel;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Directorio {
    private Map<String, Contacto> contactos;

    public Directorio() {
        this.contactos = new TreeMap<>();
    }

    public void registrarContacto(String nombre, String apellido) {
        Contacto auxiliar = new Contacto(nombre, apellido); //sabemos que no se repiten porque el mapa no admite dos llaves iguales
        contactos.put(auxiliar.getNombreCompleto(), auxiliar);
    }

    public void registrarContacto(String nombre, String apellido, Set<Telefono> numeros) {
        Contacto auxiliar = new Contacto(nombre, apellido, numeros);
        contactos.put(auxiliar.getNombreCompleto(), auxiliar);
    }

    public void removerContacto(String nombre, String apellido) {
        contactos.remove(nombre + " " + apellido); //si no existe, me va a dar null, si no, me devuelve el contacto eliminado
    }

    public void registrarTelefono(String nombre, String apellido, enumTipoTel tipoTel, String indicPais, String numTel) {
        Contacto auxiliarExiste = contactos.get(nombre + " " + apellido);
        if (auxiliarExiste == null) {
            Contacto auxiliarAgreg = new Contacto(nombre, apellido);
            auxiliarAgreg.getTelefonos().add(new Telefono(tipoTel, indicPais, numTel));
            //2° forma
            //Set<Telefono> auxTelefonos = new HashSet<>();
            //auxTelefonos.add(new Telefono(tipoTel, indicPais, numTel));
            //Contacto auxiliarAgreg = new Contacto(nombre, apellido, auxTelefonos);
            contactos.put(auxiliarAgreg.getNombreCompleto(), auxiliarAgreg);
        } else {
            Telefono auxTel = new Telefono(tipoTel, indicPais, numTel);
            auxiliarExiste.getTelefonos().add(auxTel);
        }
    }

    public void removerTelefono(String nombre, String apellido, String indicPais, String numTel) {
        //containsKey, si encuentra la llave, retorna booleano true si la encuentra
        if (contactos.containsKey(nombre + " " + apellido)) {
            Contacto auxExist = contactos.get(nombre + " " + apellido);
            boolean seEncontroTel = false;
            for (Telefono auxTel : auxExist.getTelefonos()) {
                if (auxTel.getIndicPais().equals(indicPais) && auxTel.getNumTel().equals(numTel)) {
                    seEncontroTel = true;
                    auxExist.getTelefonos().remove(auxTel);
                    break;
                }
            }
            if (!seEncontroTel) {
                System.out.println("El numero " + indicPais + " " + numTel + " no estrá registrado para " + nombre + " " + apellido + ".");
            }
        } else {
            System.out.println("El contacto " + nombre + " " + apellido + " no existe en el directorio.");
        }
    }

    public Map<String, Contacto> obtenerContacto() {
        return contactos; //es igual al get
    }
}