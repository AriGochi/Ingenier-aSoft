package mx.unam.aragon.ico.is.computadoraApi.entitys;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "computadoras")
public class Computadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clave;

    @Column (name = "marca_computadora", nullable = false, length = 50)
    private String marca;

    @Column (name = "modelo_computadora", columnDefinition = "VARCHAR(50) not null")
    private String modelo;

    @Column(name = "url_foto", nullable = true, insertable = true,
            columnDefinition = "VARCHAR(500) DEFAULT 'https://cdn1.iconfinder.com/data/icons/image-manipulations/100/13-512.png'")
    private String foto;

    @Column (name = "precio_pesos", nullable = true)
    private float precio;


    @Override
    public String toString() {
        return "Computadora{" +
                "clave=" + clave +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", foto='" + foto + '\'' +
                ", precio=" + precio +
                '}';
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Computadora(int clave, String marca, String modelo, String foto, float precio) {
        this.clave = clave;
        this.marca = marca;
        this.modelo = modelo;
        this.foto = foto;
        this.precio = precio;
    }

    public Computadora() {
    }
}
