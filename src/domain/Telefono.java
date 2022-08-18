package domain;

import java.util.Objects;

public class Telefono {
    private enumTipoTel tipoTel;
    private String indicPais;
    private String numTel;

    public Telefono(enumTipoTel tipoTel, String indicPais, String numTel) {
        this.tipoTel = tipoTel;
        this.indicPais = indicPais;
        this.numTel = numTel;
    }

    public enumTipoTel getTipoTel() {
        return tipoTel;
    }

    public String getIndicPais() {
        return indicPais;
    }

    public String getNumTel() {
        return numTel;
    }

    @Override
    public String toString() {
        return "Telefono: " + indicPais + " " + numTel + ", " + tipoTel + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return Objects.equals(indicPais, telefono.indicPais) && Objects.equals(numTel, telefono.numTel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indicPais, numTel);
    }
}