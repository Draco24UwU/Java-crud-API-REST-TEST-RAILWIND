# Entidades:

Las entidades son las clases que representan los objetos o datos que serán almacenados en la base de datos. Estas clases tienen propiedades que corresponden a los campos de la tabla de la base de datos. Generalmente, cada entidad se mapea a una tabla en la base de datos.

# Example

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "contrasena")
    private String contrasena;
    
    // Getters, setters y otros métodos
}