/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
/**
 *
 * @author admin
 */
public class ProductoRepository extends JpaRepositoty<Producto, Long> {

    List<Producto> findByPrecioGreaterThan(double precio);

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    List<Producto> findByPrecioBetween(double min, double max);

    List<Producto> findByNombreStartingWithIgnoreaCase(String prefijo);

}
