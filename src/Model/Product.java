package Model;

import java.time.LocalDate;

public class Product {
    private String codigo;
    private String descricion;
    private Integer prezo;
    private LocalDate datac;

    public Product() {
    }

    public Product(String codigo, String descricion, Integer prezo, LocalDate datac) {
        this.codigo = codigo;
        this.descricion = descricion;
        this.prezo = prezo;
        this.datac = datac;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public Integer getPrezo() {
        return prezo;
    }

    public void setPrezo(Integer prezo) {
        this.prezo = prezo;
    }

    public LocalDate getDatac() {
        return datac;
    }

    public void setDatac(LocalDate datac) {
        this.datac = datac;
    }
}
