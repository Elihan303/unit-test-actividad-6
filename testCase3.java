import org.junit.Test;
import static org.junit.Assert.*;

//Caso de Prueba 3: Realizar una Búsqueda de Productos
public class TestBuscarProductos {

    @Test
    public void testBuscarProductoExistente() {
        // Preparación
        SistemaGestionInventario sistema = new SistemaGestionInventario();
        sistema.agregarProducto(new Usuario("usuario1", "contraseña"), "Producto 1", "Descripción", "Categoría", 5.99, 50);
        sistema.agregarProducto(new Usuario("usuario1", "contraseña"), "Producto 2", "Descripción", "Categoría", 7.99, 30);

        // Acción
        ListaProductos resultados = sistema.buscarProducto("Producto 1");

        // Verificación
        assertEquals(1, resultados.size());
        assertEquals("Producto 1", resultados.get(0).getNombre());
    }

    @Test
    public void testBuscarProductoNoExistente() {
        // Preparación
        SistemaGestionInventario sistema = new SistemaGestionInventario();
        sistema.agregarProducto(new Usuario("usuario1", "contraseña"), "Producto 1", "Descripción", "Categoría", 5.99, 50);
        sistema.agregarProducto(new Usuario("usuario1", "contraseña"), "Producto 2", "Descripción", "Categoría", 7.99, 30);

        // Acción
        ListaProductos resultados = sistema.buscarProducto("Producto 3");

        // Verificación
        assertEquals(0, resultados.size());
    }
}