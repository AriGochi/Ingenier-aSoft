package mx.unam.aragon.ico.is.televisionapi.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.Objects;

@Entity
@Table(name = "television")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clave;

    @Column(name = "marca_television" , nullable = false , length = 50)
    @NotNull(message = "No puede dejar el campo sin declarar")
    @NotBlank(message = "EL campo no debe de tener solo espacios en blanco")
    private String marca;

    @Column(name = "modelo_television" ,columnDefinition = "VARCHAR(50) not null")
    @NotNull(message = "No puede dejar el campo sin declarar")
    @NotBlank(message = "EL campo no debe de tener solo espacios en blanco")
    private String modelo;

    @Column(name = "URL_foto" , nullable = false , insertable = false , columnDefinition = "VARCHAR(255) DEFAULT 'view-source:https://www.shutterstock.com/image-vector/no-photo-image-viewer-thumbnail-picture-2495883211' ")
    private String foto;

    @Column(name = "precio" , nullable = false)
    @NotNull(message = "No puede dejar el campo sin declarar")
    private Float precio;

    @Override
    public String toString() {
        return "Television{" +
                "clave=" + clave +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", foto='" + foto + '\'' +
                ", precio=" + precio +
                '}';
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
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



    public Television(Integer clave, String marca, String modelo, String foto, Float precio) {
        this.clave = clave;
        this.marca = marca;
        this.modelo = modelo;
        this.foto = foto;
        this.precio = precio;
    }

    public Television() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return Float.compare(precio, that.precio) == 0 && Objects.equals(clave, that.clave) && Objects.equals(marca, that.marca) && Objects.equals(modelo, that.modelo) && Objects.equals(foto, that.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clave, marca, modelo, foto, precio);
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
